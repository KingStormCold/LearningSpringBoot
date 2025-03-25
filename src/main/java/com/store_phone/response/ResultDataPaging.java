package com.store_phone.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResultDataPaging<T> {

	@JsonProperty("values")
	private List<T> values;
	
	@JsonProperty("pagination")
	private Pagination pagination;

	public List<T> getValues() {
		return values;
	}

	public void setValues(List<T> values) {
		this.values = values;
	}

	public Pagination getPagination() {
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}

	public ResultDataPaging(List<T> values, Pagination pagination) {
		this.values = values;
		this.pagination = pagination;
	}
	
}
