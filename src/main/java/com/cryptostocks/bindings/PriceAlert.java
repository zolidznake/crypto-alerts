package com.cryptostocks.bindings;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PriceAlert{

	@JsonProperty("target_currency")
	private String targetCurrency;

	@JsonProperty("price")
	private String price;

	@JsonProperty("currency")
	private String currency;

	@JsonProperty("exchange")
	private String exchange;

	@JsonProperty("type")
	private String type;

	@JsonProperty("message")
	private String message;

	@JsonProperty("direction")
	private String direction;

	public String getTargetCurrency(){
		return targetCurrency;
	}

	public String getPrice(){
		return price;
	}

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

	public String getDirection(){
		return direction;
	}

	@Override
 	public String toString(){
		return 
			"PriceAlert{" + 
			"target_currency = '" + targetCurrency + '\'' + 
			",price = '" + price + '\'' + 
			",currency = '" + currency + '\'' + 
			",exchange = '" + exchange + '\'' + 
			",type = '" + type + '\'' + 
			",message = '" + message + '\'' + 
			",direction = '" + direction + '\'' + 
			"}";
		}
}