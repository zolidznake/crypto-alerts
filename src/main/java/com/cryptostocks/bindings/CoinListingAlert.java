package com.cryptostocks.bindings;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CoinListingAlert{

	@JsonProperty("currency")
	private String currency;

	@JsonProperty("exchange")
	private String exchange;

	@JsonProperty("type")
	private String type;

	@JsonProperty("message")
	private String message;

	public String getCurrency(){
		return currency;
	}

	public String getExchange(){
		return exchange;
	}

	public String getType(){
		return type;
	}

	public String getMessage(){
		return message;
	}

	@Override
 	public String toString(){
		return 
			"CoinListingAlert{" + 
			"currency = '" + currency + '\'' + 
			",exchange = '" + exchange + '\'' + 
			",type = '" + type + '\'' + 
			",message = '" + message + '\'' + 
			"}";
		}
}