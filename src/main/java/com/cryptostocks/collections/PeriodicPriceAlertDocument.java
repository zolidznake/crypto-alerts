package com.cryptostocks.collections;

import io.quarkus.mongodb.panache.MongoEntity;
import io.quarkus.mongodb.panache.PanacheMongoEntity;

@MongoEntity(collection = "periodicalert", database = "crypto")
public class PeriodicPriceAlertDocument extends PanacheMongoEntity {

    public String type;
    public String message;
    public String currency;
    public String price;
    public String exchange;
    public String insertedDateTime;


}
