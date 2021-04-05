package com.cryptostocks.coinmarketcap.bindings.listings;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Status{

	@JsonProperty("error_message")
	private Object errorMessage;

	@JsonProperty("elapsed")
	private Long elapsed;

	@JsonProperty("total_count")
	private Long totalCount;

	@JsonProperty("credit_count")
	private Long creditCount;

	@JsonProperty("error_code")
	private Long errorCode;

	@JsonProperty("timestamp")
	private String timestamp;

	@JsonProperty("notice")
	private Object notice;

	public Object getErrorMessage(){
		return errorMessage;
	}

	public Long getElapsed(){
		return elapsed;
	}

	public Long getTotalCount(){
		return totalCount;
	}

	public Long getCreditCount(){
		return creditCount;
	}

	public Long getErrorCode(){
		return errorCode;
	}

	public String getTimestamp(){
		return timestamp;
	}

	public Object getNotice(){
		return notice;
	}
}