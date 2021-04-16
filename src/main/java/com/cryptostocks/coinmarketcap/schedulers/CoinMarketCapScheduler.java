package com.cryptostocks.coinmarketcap.schedulers;


import com.cryptostocks.coinmarketcap.client.CoinMarketCapService;
import io.quarkus.scheduler.Scheduled;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class CoinMarketCapScheduler {


    @Inject
    CoinMarketCapService coinMarketCapService;

    @Scheduled(every = "30m")
    /*
    “At minute 30 past every 2nd hour from 0 through 20.”
     */
    public void refreshTokenList(){
        coinMarketCapService.callAllTokensMap();
    }
}
