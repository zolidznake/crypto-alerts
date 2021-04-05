package com.cryptostocks.bindings;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


public class PercentPriceAlert{

	@JsonCreator
	public PercentPriceAlert(@JsonProperty("currency") String currency,
							 @JsonProperty("exchange") String exchange,
							 @JsonProperty("current_price") String currentPrice,
							 @JsonProperty("window") String window,
							 @JsonProperty("type") String type,
							 @JsonProperty("message")  String message,
							 @JsonProperty("percent") String percent,
							 @JsonProperty("direction") String direction) {
		this.currency = currency;
		this.exchange = exchange;
		this.currentPrice = currentPrice;
		this.window = window;
		this.type = type;
		this.message = message;
		this.percent = percent;
		this.direction = direction;
	}

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