package com.cryptostocks.bindings;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BTCDominanceAlert{

	@JsonProperty("currency")
	private String currency;

	@JsonProperty("threshold")
	private String threshold;

	@JsonProperty("type")
	private String type;

	@JsonProperty("message")
	private String message;

	@JsonProperty("direction")
	private String direction;

	public String getCurrency(){
		return currency;
	}

	public String getThreshold(){
		return threshold;
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
			"BTCDominanceAlert{" + 
			"currency = '" + currency + '\'' + 
			",threshold = '" + threshold + '\'' + 
			",type = '" + type + '\'' + 
			",message = '" + message + '\'' + 
			",direction = '" + direction + '\'' + 
			"}";
		}
}