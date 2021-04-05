package com.cryptostocks.coinmarketcap.bindings.listings;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Platform{

	@JsonProperty("symbol")
	private String symbol;

	@JsonProperty("name")
	private String name;

	@JsonProperty("token_address")
	private String tokenAddress;

	@JsonProperty("id")
	private Long id;

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

	public Long getId(){
		return id;
	}

	public String getSlug(){
		return slug;
	}
}