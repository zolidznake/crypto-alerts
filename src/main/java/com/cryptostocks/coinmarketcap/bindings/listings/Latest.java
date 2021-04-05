package com.cryptostocks.coinmarketcap.bindings.listings;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Latest{

	@JsonProperty("data")
	private List<DataItem> data;

	@JsonProperty("status")
	private Status status;

	public List<DataItem> getData(){
		return data;
	}

	public Status getStatus(){
		return status;
	}
}