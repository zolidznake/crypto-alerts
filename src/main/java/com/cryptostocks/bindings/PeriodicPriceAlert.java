package com.cryptostocks.bindings;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PeriodicPriceAlert{

	@JsonCreator
	public PeriodicPriceAlert(@JsonProperty("target_currency") String targetCurrency,
							  @JsonProperty("price") String price,
							  @JsonProperty("currency") String currency,
							  @JsonProperty("exchange") String exchange,
							  @JsonProperty("type") String type,
							  @JsonProperty("message") String message) {
		this.targetCurrency = targetCurrency;
		this.price = price;
		this.currency = currency;
		this.exchange = exchange;
		this.type = type;
		this.message = message;
	}

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

	@Override
 	public String toString(){
		return 
			"PeriodicPriceAlert{" + 
			"target_currency = '" + targetCurrency + '\'' + 
			",price = '" + price + '\'' + 
			",currency = '" + currency + '\'' + 
			",exchange = '" + exchange + '\'' + 
			",type = '" + type + '\'' + 
			",message = '" + message + '\'' + 
			"}";
		}
}