package com.cryptostocks.bindings;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class WalletWatchAlert{

	@JsonCreator
	public WalletWatchAlert(@JsonProperty("address") String address,
							@JsonProperty("blockchain") String blockchain,
							@JsonProperty("currency") String currency,
							@JsonProperty("type") String type,
							@JsonProperty("message") String message,
							@JsonProperty("value")String value) {
		this.address = address;
		this.blockchain = blockchain;
		this.currency = currency;
		this.type = type;
		this.message = message;
		this.value = value;
	}

	@JsonProperty("address")
	private String address;

	@JsonProperty("blockchain")
	private String blockchain;

	@JsonProperty("currency")
	private String currency;

	@JsonProperty("type")
	private String type;

	@JsonProperty("message")
	private String message;

	@JsonProperty("value")
	private String value;

	public String getAddress(){
		return address;
	}

	public String getBlockchain(){
		return blockchain;
	}

	public String getCurrency(){
		return currency;
	}

	public String getType(){
		return type;
	}

	public String getMessage(){
		return message;
	}

	public String getValue(){
		return value;
	}

	@Override
 	public String toString(){
		return 
			"WalletWatchAlert{" + 
			"address = '" + address + '\'' + 
			",blockchain = '" + blockchain + '\'' + 
			",currency = '" + currency + '\'' + 
			",type = '" + type + '\'' + 
			",message = '" + message + '\'' + 
			",value = '" + value + '\'' + 
			"}";
		}
}