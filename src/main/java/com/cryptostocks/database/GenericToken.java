package com.cryptostocks.database;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.quarkus.mongodb.panache.MongoEntity;
import io.quarkus.mongodb.panache.PanacheMongoEntity;

import java.time.LocalDateTime;
import java.util.List;

@MongoEntity(collection = "generic")
public class GenericToken extends PanacheMongoEntity {

    public String symbol;
    public int isActive;
    public String lastHistoricalData;
    public String name;
    public int rank;
    public int id;
    public String slug;
    public Object platform;
    public String firstHistoricalData;
    public LocalDateTime insertedDateTime;
    public LocalDateTime modifiedDateTime;

    public static GenericToken findBySymbol(String symbol){
        return find("symbol", symbol).firstResult();
    }

    public static GenericToken findById(int id){
        return find("id", id).firstResult();
    }

    public static List<GenericToken>  findInactiveTokens(){
        return list("isActive", true);
    }

    public static GenericToken findByRank(int rank){
        return find("rank", rank).firstResult();
    }


}
