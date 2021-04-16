package com.cryptostocks.collections;

import io.quarkus.mongodb.panache.MongoEntity;
import io.quarkus.mongodb.panache.PanacheMongoEntity;

import java.util.List;

@MongoEntity(collection = "percentpricealert", database = "crypto")
public class PercentPriceAlertDocument extends PanacheMongoEntity {

    public String type;
    public String message;
    public String currency;
    public String direction;
    public String percent;
    public String current_price;
    public String window;
    public String exchange;
    public String insertedDateTime;


    public List<PercentPriceAlertDocument> findByPercentsAndCurrency(String percent, String currency){
       return list("percent, currency", percent, currency);
    }


    public List<PercentPriceAlertDocument> findByCurrency(String currency){
        return list("currency", currency);
    }

}
