package com.cryptostocks.coinmarketcap.bindings.map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DataItem{

	@JsonProperty("symbol")
	private String symbol;

	@JsonProperty("is_active")
	private int isActive;

	@JsonProperty("last_historical_data")
	private String lastHistoricalData;

	@JsonProperty("name")
	private String name;

	@JsonProperty("rank")
	private int rank;

	@JsonProperty("id")
	private int id;

	@JsonProperty("slug")
	private String slug;

	@JsonProperty("platform")
	private Platform platform;

	@JsonProperty("first_historical_data")
	private String firstHistoricalData;

	public String getSymbol(){
		return symbol;
	}

	public int getIsActive(){
		return isActive;
	}

	public String getLastHistoricalData(){
		return lastHistoricalData;
	}

	public String getName(){
		return name;
	}

	public int getRank(){
		return rank;
	}

	public int getId(){
		return id;
	}

	public String getSlug(){
		return slug;
	}

	public Platform getPlatform(){
		return platform;
	}

	public String getFirstHistoricalData(){
		return firstHistoricalData;
	}

	@Override
 	public String toString(){
		return 
			"DataItem{" + 
			"symbol = '" + symbol + '\'' + 
			",is_active = '" + isActive + '\'' + 
			",last_historical_data = '" + lastHistoricalData + '\'' + 
			",name = '" + name + '\'' + 
			",rank = '" + rank + '\'' + 
			",id = '" + id + '\'' + 
			",slug = '" + slug + '\'' + 
			",platform = '" + platform + '\'' + 
			",first_historical_data = '" + firstHistoricalData + '\'' + 
			"}";
		}
}