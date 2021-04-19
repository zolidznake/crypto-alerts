package com.cryptostocks.collections;

import io.quarkus.mongodb.panache.MongoEntity;
import io.quarkus.mongodb.panache.PanacheMongoEntity;

@MongoEntity(collection = "blockchainalert", database = "crypto")
public class BlockchainAlertDocument extends PanacheMongoEntity {
    public String type;
    public String message;
    public String blockchain;
    public String metric;
    public String direction;
    public String threshold;
    public String insertedDateTime;

}
