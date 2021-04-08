package com.cryptostocks.coinmarketcap.client;

import com.cryptostocks.coinmarketcap.client.api.AllTokensMapControllerApi;
import com.cryptostocks.coinmarketcap.client.api.LatestListingsControllerApi;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class CoinMarketCapService {

    @Inject
    LatestListingsControllerApi listingsControllerApi;

    @Inject
    AllTokensMapControllerApi allTokensMapControllerApi;

    public void callLatestListing(){
        listingsControllerApi.start();
    }

    public void callAllTokensMap(){
        allTokensMapControllerApi.start();
    }
}


