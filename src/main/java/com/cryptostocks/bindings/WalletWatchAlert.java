package com.cryptostocks.bindings;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WalletWatchAlert{

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