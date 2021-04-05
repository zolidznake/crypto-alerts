package com.cryptostocks.coinmarketcap.client;

import com.cryptostocks.coinmarketcap.bindings.listings.Latest;
import retrofit2.Call;
import retrofit2.http.GET;

public interface CoinMarketCapRestClient {

    @GET( "v1/cryptocurrency/listings/latest")
    Call<Latest> getLatestList();
}
