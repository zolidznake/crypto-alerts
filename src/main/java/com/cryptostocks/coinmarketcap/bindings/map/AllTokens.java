package com.cryptostocks.coinmarketcap.bindings.map;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AllTokens{

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

	@Override
 	public String toString(){
		return 
			"AllTokens{" + 
			"data = '" + data + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}