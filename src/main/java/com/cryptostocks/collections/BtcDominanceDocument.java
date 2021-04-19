package com.cryptostocks.collections;

import io.quarkus.mongodb.panache.MongoEntity;
import io.quarkus.mongodb.panache.PanacheMongoEntity;

@MongoEntity(collection = "dominance", database = "crypto")
public class BtcDominanceDocument extends PanacheMongoEntity {
    public String type;
    public String message;
    public String currency;
    public String direction;
    public String threshold;
    public String insertedDateTime;
}
