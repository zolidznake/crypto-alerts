package com.cryptostocks.collections;

import io.quarkus.mongodb.panache.MongoEntity;
import io.quarkus.mongodb.panache.PanacheMongoEntity;

@MongoEntity(collection = "btcmempool", database = "crypto")
public class BtcMemPoolDocument extends PanacheMongoEntity {

    public String type;
    public String message;
    public String direction;
    public String threshold;
    public String metric;
    public String insertedDateTime;
}
