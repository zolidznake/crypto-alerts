package com.cryptostocks.coinmarketcap.client.api;

import com.cryptostocks.coinmarketcap.bindings.listings.DataItem;
import com.cryptostocks.coinmarketcap.bindings.listings.Latest;
import com.cryptostocks.coinmarketcap.client.AuthInterceptor;
import com.cryptostocks.coinmarketcap.client.CoinMarketCapRestClient;
import com.cryptostocks.database.CryptoToken;
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
public class LatestListingsControllerApi  implements Callback<Latest> {

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
        Call<Latest> call = coinMarketCapRestClient.getLatestList();
        call.enqueue(this);
    }


    @Override
    public void onResponse(Call<Latest> call, Response<Latest> response) {

        if (response.isSuccessful()) {
            Latest latest = response.body();
            latest.getData().stream().forEach(LatestListingsControllerApi::persistToDB);
        }
    }

    @Override
    public void onFailure(Call<Latest> call, Throwable throwable) {
        throwable.printStackTrace();
    }


    private static void persistToDB(DataItem crypto) {
        CryptoToken persistenceCryptoToken = new CryptoToken();
        persistenceCryptoToken.symbol = crypto.getSymbol();
        persistenceCryptoToken.circulatingSupply = crypto.getCirculatingSupply();
        persistenceCryptoToken.lastUpdated = crypto.getLastUpdated();
        persistenceCryptoToken.totalSupply = crypto.getTotalSupply();
        persistenceCryptoToken.cmcRank = crypto.getCmcRank();
        persistenceCryptoToken.platform = crypto.getPlatform();
        persistenceCryptoToken.tags = crypto.getTags();
        persistenceCryptoToken.dateAdded = crypto.getDateAdded();
        persistenceCryptoToken.quote = crypto.getQuote();
        persistenceCryptoToken.numMarketPairs = crypto.getNumMarketPairs();
        persistenceCryptoToken.name = crypto.getName();
        persistenceCryptoToken.maxSupply = crypto.getMaxSupply();
        persistenceCryptoToken.id = crypto.getId();
        persistenceCryptoToken.slug = crypto.getSlug();
        persistenceCryptoToken.insertedDateTime = LocalDateTime.now();
        persistenceCryptoToken.persistOrUpdate();
    }
}
