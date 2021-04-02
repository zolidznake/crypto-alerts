package com.cryptostocks.bindings;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PercentPriceAlert{

	@JsonProperty("currency")
	private String currency;

	@JsonProperty("exchange")
	private String exchange;

	@JsonProperty("current_price")
	private String currentPrice;

	@JsonProperty("window")
	private String window;

	@JsonProperty("type")
	private String type;

	@JsonProperty("message")
	private String message;

	@JsonProperty("percent")
	private String percent;

	@JsonProperty("direction")
	private String direction;

	public String getCurrency(){
		return currency;
	}

	public String getExchange(){
		return exchange;
	}

	public String getCurrentPrice(){
		return currentPrice;
	}

	public String getWindow(){
		return window;
	}

	public String getType(){
		return type;
	}

	public String getMessage(){
		return message;
	}

	public String getPercent(){
		return percent;
	}

	public String getDirection(){
		return direction;
	}
}