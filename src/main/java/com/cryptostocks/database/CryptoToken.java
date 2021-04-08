package com.cryptostocks.database;

import com.cryptostocks.coinmarketcap.bindings.listings.Quote;
import io.quarkus.mongodb.panache.MongoEntity;
import io.quarkus.mongodb.panache.PanacheMongoEntity;

import java.time.LocalDateTime;
import java.util.List;

@MongoEntity(collection = "crypto")
public class CryptoToken extends PanacheMongoEntity {

    public String symbol;
    public Long circulatingSupply;
    public String lastUpdated;
    public Long totalSupply;
    public Long cmcRank;
    public Object platform;
    public List<String> tags;
    public String dateAdded;
    public Quote quote;
    public Long numMarketPairs;
    public String name;
    public Long maxSupply;
    public Long id;
    public String slug;
    public Boolean obsoleted;
    public LocalDateTime insertedDateTime;
    public LocalDateTime modifiedDateTime;

    public static List<CryptoToken> findAllTokens(){
        return listAll();
    }

    public static CryptoToken findBySymbol(String symbol){
        return find("symbol", symbol).firstResult();
    }

    public static List<CryptoToken> findObsoletedTokens(){
        return list("obsoleted", true);
    }

    public static List<CryptoToken> findByTotalSupply(Long totalSupply){
        return list("totalSupply", totalSupply);
    }

    public static List<CryptoToken> findByMaxSupply(Long maxSupply){
        return list("maxSupply", maxSupply);
    }
}
