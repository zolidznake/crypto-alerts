package com.cryptostocks.collections;

import com.cryptostocks.coinmarketcap.bindings.map.Platform;
import io.quarkus.mongodb.panache.MongoEntity;
import io.quarkus.mongodb.panache.PanacheMongoEntity;

import java.time.LocalDateTime;
import java.util.List;

@MongoEntity(collection = "generic", database = "crypto")
public class GenericTokenDocument extends PanacheMongoEntity {

    public String symbol;
    public int isActive;
    public String lastHistoricalData;
    public String name;
    public int rank;
    public int id;
    public String slug;
    public Platform platform;
    public String firstHistoricalData;
    public LocalDateTime insertedDateTime;
    public LocalDateTime modifiedDateTime;

    public static GenericTokenDocument findBySymbol(String symbol){
        return find("symbol", symbol).firstResult();
    }

    public static GenericTokenDocument findById(int id){
        return find("id", id).firstResult();
    }

    public static List<GenericTokenDocument>  findInactiveTokens(){
        return list("isActive", true);
    }

    public static GenericTokenDocument findByRank(int rank){
        return find("rank", rank).firstResult();
    }


}
