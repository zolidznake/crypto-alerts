package com.cryptostocks.bindings;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BitcoinMempoolAlert{

	@JsonProperty("metric")
	private String metric;

	@JsonProperty("threshold")
	private String threshold;

	@JsonProperty("type")
	private String type;

	@JsonProperty("message")
	private String message;

	@JsonProperty("direction")
	private String direction;

	public String getMetric(){
		return metric;
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
			"BitcoinMempoolAlert{" + 
			"metric = '" + metric + '\'' + 
			",threshold = '" + threshold + '\'' + 
			",type = '" + type + '\'' + 
			",message = '" + message + '\'' + 
			",direction = '" + direction + '\'' + 
			"}";
		}
}