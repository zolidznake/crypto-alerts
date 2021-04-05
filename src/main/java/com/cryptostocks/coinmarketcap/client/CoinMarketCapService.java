package com.cryptostocks.coinmarketcap.client;

import com.cryptostocks.coinmarketcap.bindings.listings.Latest;
import okhttp3.OkHttpClient;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class CoinMarketCapService implements Callback<Latest> {

    @Inject
    AuthInterceptor authInterceptor;

    @ConfigProperty(name ="coinmarketcap.baseurl")
     String BASE_URL;

    public void start(){
      var builder =  new OkHttpClient.Builder();
      builder.interceptors().add(authInterceptor);
      var client = builder.build();

        Retrofit api = new Retrofit.Builder().baseUrl(BASE_URL)
                .client(client).addConverterFactory(JacksonConverterFactory.create()).build();

        CoinMarketCapRestClient  coinMarketCapRestClient = api.create(CoinMarketCapRestClient.class);
        Call<Latest> call = coinMarketCapRestClient.getLatestList();
        call.enqueue(this);
    }



    @Override
    public void onResponse(Call<Latest> call, Response<Latest> response) {

        if(response.isSuccessful()){
            Latest latest = response.body();

        }
    }

    @Override
    public void onFailure(Call<Latest> call, Throwable throwable) {
        throwable.printStackTrace();
    }
}
