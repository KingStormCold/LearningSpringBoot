package com.store_phone.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Pagination {

	@JsonProperty("page_number")
	private int pageNumber;
	
	@JsonProperty("page_size")
	private int pageSize;
	
	@JsonProperty("totalPage")
	private int totalPage;

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public Pagination(int pageNumber, int pageSize, int totalPage) {
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
		this.totalPage = totalPage;
	}

}
