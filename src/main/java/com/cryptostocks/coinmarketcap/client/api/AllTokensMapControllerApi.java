package com.cryptostocks.coinmarketcap.client.api;

import com.cryptostocks.coinmarketcap.bindings.map.AllTokens;
import com.cryptostocks.coinmarketcap.client.AuthInterceptor;
import com.cryptostocks.coinmarketcap.client.CoinMarketCapRestClient;
import com.cryptostocks.collections.GenericTokenDocument;
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
import java.util.Objects;

@ApplicationScoped
public class AllTokensMapControllerApi  implements Callback<AllTokens> {

    @Inject
    AuthInterceptor authInterceptor;

    @ConfigProperty(name = "coinmarketcap.baseurl")
    String baseUrlString;

    public void start() {
        var builder = new OkHttpClient.Builder();
        builder.interceptors().add(authInterceptor);
        var client = builder.build();

        Retrofit api = new Retrofit.Builder().baseUrl(baseUrlString)
                .client(client).addConverterFactory(JacksonConverterFactory.create()).build();

        CoinMarketCapRestClient coinMarketCapRestClient = api.create(CoinMarketCapRestClient.class);
        Call<AllTokens> call = coinMarketCapRestClient.getAllTokens();
        call.enqueue(this);
    }



    @Override
    public void onResponse(Call<AllTokens> call, Response<AllTokens> response) {
        if(response.isSuccessful()){
            AllTokens tokens = response.body();
            Objects.requireNonNull(tokens).getData().forEach(cryptoToken->{
                GenericTokenDocument genericTokenDocument = new GenericTokenDocument();
                genericTokenDocument.id = cryptoToken.getId();
                genericTokenDocument.symbol = cryptoToken.getSymbol();
                genericTokenDocument.name = cryptoToken.getName();
                genericTokenDocument.rank = cryptoToken.getRank();
                genericTokenDocument.isActive = cryptoToken.getIsActive();
                genericTokenDocument.firstHistoricalData = cryptoToken.getFirstHistoricalData();
                genericTokenDocument.lastHistoricalData = cryptoToken.getLastHistoricalData();
                genericTokenDocument.insertedDateTime = LocalDateTime.now();
                genericTokenDocument.slug = cryptoToken.getSlug();
                genericTokenDocument.platform = cryptoToken.getPlatform();
                genericTokenDocument.persistOrUpdate();
            });
        }
    }

    @Override
    public void onFailure(Call<AllTokens> call, Throwable throwable) {
        throwable.printStackTrace();
    }
}
