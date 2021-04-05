package com.cryptostocks.bindings;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BlockchainAlert{

	@JsonCreator
	public BlockchainAlert(@JsonProperty("blockchain") String blockchain,
						   @JsonProperty("metric") String metric,
						   @JsonProperty("threshold") String threshold,
						   @JsonProperty("type") String type,
						   @JsonProperty("message") String message,
						   @JsonProperty("direction") String direction) {
		this.blockchain = blockchain;
		this.metric = metric;
		this.threshold = threshold;
		this.type = type;
		this.message = message;
		this.direction = direction;
	}

	@JsonProperty("blockchain")
	private String blockchain;

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

	public String getBlockchain(){
		return blockchain;
	}

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
			"BlockchainAlert{" + 
			"blockchain = '" + blockchain + '\'' + 
			",metric = '" + metric + '\'' + 
			",threshold = '" + threshold + '\'' + 
			",type = '" + type + '\'' + 
			",message = '" + message + '\'' + 
			",direction = '" + direction + '\'' + 
			"}";
		}
}