package com.cryptostocks.collections;

import io.quarkus.mongodb.panache.PanacheMongoEntity;

public class MarketCapAlertDocument extends PanacheMongoEntity {
    public String type;
    public String message;
    public String currency;
    public String direction;
    public String threshold;
    public String insertedDateTime;
}
