package com.cryptostocks.coinmarketcap.client.api;

import com.cryptostocks.coinmarketcap.bindings.listings.DataItem;
import com.cryptostocks.coinmarketcap.bindings.listings.Latest;
import com.cryptostocks.coinmarketcap.client.AuthInterceptor;
import com.cryptostocks.coinmarketcap.client.CoinMarketCapRestClient;
import com.cryptostocks.collections.CryptoTokenDocument;
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
public class LatestListingsControllerApi  implements Callback<Latest> {

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
        Call<Latest> call = coinMarketCapRestClient.getLatestList();
        call.enqueue(this);
    }


    @Override
    public void onResponse(Call<Latest> call, Response<Latest> response) {

        if (response.isSuccessful()) {
            Latest latest = response.body();
            Objects.requireNonNull(latest).getData().forEach(LatestListingsControllerApi::persistToDB);
        }
    }

    @Override
    public void onFailure(Call<Latest> call, Throwable throwable) {
        throwable.printStackTrace();
    }


    private static void persistToDB(DataItem crypto) {
        CryptoTokenDocument persistenceCryptoTokenDocument = new CryptoTokenDocument();
        persistenceCryptoTokenDocument.symbol = crypto.getSymbol();
        persistenceCryptoTokenDocument.circulatingSupply = crypto.getCirculatingSupply();
        persistenceCryptoTokenDocument.lastUpdated = crypto.getLastUpdated();
        persistenceCryptoTokenDocument.totalSupply = crypto.getTotalSupply();
        persistenceCryptoTokenDocument.cmcRank = crypto.getCmcRank();
        persistenceCryptoTokenDocument.platform = crypto.getPlatform();
        persistenceCryptoTokenDocument.tags = crypto.getTags();
        persistenceCryptoTokenDocument.dateAdded = crypto.getDateAdded();
        persistenceCryptoTokenDocument.quote = crypto.getQuote();
        persistenceCryptoTokenDocument.numMarketPairs = crypto.getNumMarketPairs();
        persistenceCryptoTokenDocument.name = crypto.getName();
        persistenceCryptoTokenDocument.maxSupply = crypto.getMaxSupply();
        persistenceCryptoTokenDocument.id = crypto.getId();
        persistenceCryptoTokenDocument.slug = crypto.getSlug();
        persistenceCryptoTokenDocument.insertedDateTime = LocalDateTime.now();
        persistenceCryptoTokenDocument.persistOrUpdate();
    }
}
