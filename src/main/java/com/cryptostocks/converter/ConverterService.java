package com.cryptostocks.converter;

import com.cryptostocks.constants.CryptoAlertType;

import javax.enterprise.context.ApplicationScoped;
import java.util.HashMap;
import java.util.Map;


@ApplicationScoped
public class ConverterService {

    Map<String, AlertConverter> convertersMap = new HashMap<>();

    private ConverterService() {

        convertersMap.put(CryptoAlertType.BITCOIN_MEMPOOL_ALERT, new BitcoinMempoolAlertConverter());
        convertersMap.put(CryptoAlertType.BLOCKCHAIN_ALERT, new BlockchainAlertConverter());
        convertersMap.put(CryptoAlertType.BTC_DOMINANCE_ALERT, new BTCDominanceAlertConverter());
        convertersMap.put(CryptoAlertType.NEW_COIN_LISTING_ALERT, new CoinListingAlertConverter());
        convertersMap.put(CryptoAlertType.MARKETCAP_ALERT, new MarketCapAlertConverter());
        convertersMap.put(CryptoAlertType.PERCENT_PRICE_ALERT, new PercentPriceAlertConverter());
        convertersMap.put(CryptoAlertType.PERIODIC_PRICE_ALERT, new PeriodicPriceAlertConverter());
        convertersMap.put(CryptoAlertType.PRICE_ALERT, new PriceAlertConverter());
        convertersMap.put(CryptoAlertType.WALLET_WATCH_ALERT, new WalletWatchAlertConverter());
    }

    public AlertConverter getAlertConverter(String cryptoAlertType) {
        return convertersMap.get(cryptoAlertType);
    }

}
