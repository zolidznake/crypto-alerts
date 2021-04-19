package com.cryptostocks.collections;

import io.quarkus.mongodb.panache.MongoEntity;
import io.quarkus.mongodb.panache.PanacheMongoEntity;

@MongoEntity(collection = "walletwatch", database = "crypto")
public class WalletWatchAlertDocument extends PanacheMongoEntity {

    public String type;
    public String message;
    public String blockchain;
    public String address;
    public String currency;
    public String value;
    public String insertedDateTime;
}
