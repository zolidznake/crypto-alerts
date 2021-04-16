package com.cryptostocks.collections;

import io.quarkus.mongodb.panache.MongoEntity;
import io.quarkus.mongodb.panache.PanacheMongoEntity;

import java.util.List;

@MongoEntity(collection = "coinlisting", database = "crypto")
public class CoinListingAlertDocument extends PanacheMongoEntity {

    public String type;
    public String message;
    public String currency;
    public String exchange;
    public String insertedDateTime;




    public List<CoinListingAlertDocument> findAllByCurrency(String currency){
        return list("currency", currency);
    }

    public List<CoinListingAlertDocument> findAllByExchange(String exchange){
        return list("exchange", exchange);
    }


}
