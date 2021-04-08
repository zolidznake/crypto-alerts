package com.cryptostocks.coinmarketcap.bindings.map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Platform{

	@JsonProperty("symbol")
	private String symbol;

	@JsonProperty("name")
	private String name;

	@JsonProperty("token_address")
	private String tokenAddress;

	@JsonProperty("id")
	private int id;

	@JsonProperty("slug")
	private String slug;

	public String getSymbol(){
		return symbol;
	}

	public String getName(){
		return name;
	}

	public String getTokenAddress(){
		return tokenAddress;
	}

	public int getId(){
		return id;
	}

	public String getSlug(){
		return slug;
	}

	@Override
 	public String toString(){
		return 
			"Platform{" + 
			"symbol = '" + symbol + '\'' + 
			",name = '" + name + '\'' + 
			",token_address = '" + tokenAddress + '\'' + 
			",id = '" + id + '\'' + 
			",slug = '" + slug + '\'' + 
			"}";
		}
}