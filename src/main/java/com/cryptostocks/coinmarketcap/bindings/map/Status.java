package com.cryptostocks.coinmarketcap.bindings.map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Status{

	@JsonProperty("error_message")
	private Object errorMessage;

	@JsonProperty("elapsed")
	private int elapsed;

	@JsonProperty("credit_count")
	private int creditCount;

	@JsonProperty("error_code")
	private int errorCode;

	@JsonProperty("timestamp")
	private String timestamp;

	@JsonProperty("notice")
	private Object notice;

	public Object getErrorMessage(){
		return errorMessage;
	}

	public int getElapsed(){
		return elapsed;
	}

	public int getCreditCount(){
		return creditCount;
	}

	public int getErrorCode(){
		return errorCode;
	}

	public String getTimestamp(){
		return timestamp;
	}

	public Object getNotice(){
		return notice;
	}

	@Override
 	public String toString(){
		return 
			"Status{" + 
			"error_message = '" + errorMessage + '\'' + 
			",elapsed = '" + elapsed + '\'' + 
			",credit_count = '" + creditCount + '\'' + 
			",error_code = '" + errorCode + '\'' + 
			",timestamp = '" + timestamp + '\'' + 
			",notice = '" + notice + '\'' + 
			"}";
		}
}