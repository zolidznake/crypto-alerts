package com.cryptostocks.coinmarketcap.client;

import com.cryptostocks.coinmarketcap.bindings.listings.Latest;
import com.cryptostocks.coinmarketcap.bindings.map.AllTokens;
import retrofit2.Call;
import retrofit2.http.GET;

public interface CoinMarketCapRestClient {

    @GET( "v1/cryptocurrency/listings/latest")
    Call<Latest> getLatestList();

    @GET("v1/cryptocurrency/map")
    Call<AllTokens> getAllTokens();
}
