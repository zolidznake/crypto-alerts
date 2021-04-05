package com.cryptostocks.coinmarketcap.bindings.listings;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DataItem{

	@JsonProperty("symbol")
	private String symbol;

	@JsonProperty("circulating_supply")
	private Long circulatingSupply;

	@JsonProperty("last_updated")
	private String lastUpdated;

	@JsonProperty("total_supply")
	private Long totalSupply;

	@JsonProperty("cmc_rank")
	private Long cmcRank;

	@JsonProperty("platform")
	private Object platform;

	@JsonProperty("tags")
	private List<String> tags;

	@JsonProperty("date_added")
	private String dateAdded;

	@JsonProperty("quote")
	private Quote quote;

	@JsonProperty("num_market_pairs")
	private Long numMarketPairs;

	@JsonProperty("name")
	private String name;

	@JsonProperty("max_supply")
	private Long maxSupply;

	@JsonProperty("id")
	private Long id;

	@JsonProperty("slug")
	private String slug;

	public String getSymbol(){
		return symbol;
	}

	public Long getCirculatingSupply(){
		return circulatingSupply;
	}

	public String getLastUpdated(){
		return lastUpdated;
	}

	public Long getTotalSupply(){
		return totalSupply;
	}

	public Long getCmcRank(){
		return cmcRank;
	}

	public Object getPlatform(){
		return platform;
	}

	public List<String> getTags(){
		return tags;
	}

	public String getDateAdded(){
		return dateAdded;
	}

	public Quote getQuote(){
		return quote;
	}

	public Long getNumMarketPairs(){
		return numMarketPairs;
	}

	public String getName(){
		return name;
	}

	public Long getMaxSupply(){
		return maxSupply;
	}

	public Long getId(){
		return id;
	}

	public String getSlug(){
		return slug;
	}
}