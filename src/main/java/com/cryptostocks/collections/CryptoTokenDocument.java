package com.cryptostocks.collections;

import com.cryptostocks.coinmarketcap.bindings.listings.Quote;
import io.quarkus.mongodb.panache.MongoEntity;
import io.quarkus.mongodb.panache.PanacheMongoEntity;

import java.time.LocalDateTime;
import java.util.List;

@MongoEntity(collection = "cryptostocks", database = "crypto")
public class CryptoTokenDocument extends PanacheMongoEntity {

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

    public static List<CryptoTokenDocument> findAllTokens(){
        return listAll();
    }

    public static CryptoTokenDocument findBySymbol(String symbol){
        return find("symbol", symbol).firstResult();
    }

    public static List<CryptoTokenDocument> findObsoletedTokens(){
        return list("obsoleted", true);
    }

    public static List<CryptoTokenDocument> findByTotalSupply(Long totalSupply){
        return list("totalSupply", totalSupply);
    }

    public static List<CryptoTokenDocument> findByMaxSupply(Long maxSupply){
        return list("maxSupply", maxSupply);
    }
}
