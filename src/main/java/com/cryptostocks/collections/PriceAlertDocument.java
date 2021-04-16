package com.cryptostocks.collections;

import io.quarkus.mongodb.panache.MongoEntity;
import io.quarkus.mongodb.panache.PanacheMongoEntity;

import java.util.List;

@MongoEntity(collection = "pricealert", database = "crypto")
public class PriceAlertDocument extends PanacheMongoEntity {

    public String type;
    public String message;
    public String currency;
    public String direction;
    public String price;
    public String target_currency;
    public String exchange;
    public String insertedDateTime;

    public List<PriceAlertDocument> findByCurrency(String currency){
        return list("currency", currency);
    }

    public List<PriceAlertDocument> findByExchange(String exchange){
        return list("exchange", exchange);
    }


}
