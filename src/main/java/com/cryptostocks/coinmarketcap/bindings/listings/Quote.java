package com.cryptostocks.coinmarketcap.bindings.listings;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Quote{

	@JsonProperty("USD")
	private USD uSD;

	public USD getUSD(){
		return uSD;
	}
}