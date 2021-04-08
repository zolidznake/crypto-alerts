package com.cryptostocks.coinmarketcap.client.api;

import com.cryptostocks.coinmarketcap.bindings.listings.Latest;
import com.cryptostocks.coinmarketcap.bindings.map.AllTokens;
import com.cryptostocks.coinmarketcap.client.AuthInterceptor;
import com.cryptostocks.coinmarketcap.client.CoinMarketCapRestClient;
import com.cryptostocks.database.GenericToken;
import okhttp3.OkHttpClient;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.time.LocalDateTime;

@ApplicationScoped
public class AllTokensMapControllerApi  implements Callback<AllTokens> {

    @Inject
    AuthInterceptor authInterceptor;

    @ConfigProperty(name = "coinmarketcap.baseurl")
    String BASE_URL;

    public void start() {
        var builder = new OkHttpClient.Builder();
        builder.interceptors().add(authInterceptor);
        var client = builder.build();

        Retrofit api = new Retrofit.Builder().baseUrl(BASE_URL)
                .client(client).addConverterFactory(JacksonConverterFactory.create()).build();

        CoinMarketCapRestClient coinMarketCapRestClient = api.create(CoinMarketCapRestClient.class);
        Call<AllTokens> call = coinMarketCapRestClient.getAllTokens();
        call.enqueue(this);
    }



    @Override
    public void onResponse(Call<AllTokens> call, Response<AllTokens> response) {
        if(response.isSuccessful()){
            AllTokens tokens = response.body();
            tokens.getData().stream().forEach(cryptoToken->{
                GenericToken genericToken = new GenericToken();
                genericToken.id = cryptoToken.getId();
                genericToken.symbol = cryptoToken.getSymbol();
                genericToken.name = cryptoToken.getName();
                genericToken.rank = cryptoToken.getRank();
                genericToken.isActive = cryptoToken.getIsActive();
                genericToken.firstHistoricalData = cryptoToken.getFirstHistoricalData();
                genericToken.lastHistoricalData = cryptoToken.getLastHistoricalData();
                genericToken.insertedDateTime = LocalDateTime.now();
                genericToken.slug = cryptoToken.getSlug();
                genericToken.platform = cryptoToken.getPlatform();
                genericToken.persistOrUpdate();
            });
        }
    }

    @Override
    public void onFailure(Call<AllTokens> call, Throwable throwable) {
        throwable.printStackTrace();
    }
}
