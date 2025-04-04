package com.store_phone.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.store_phone.common.Pagination;

import java.util.List;

public class ResultDataPaging<T> {

    @JsonProperty("values")
    private List<?> values;
    @JsonProperty("pagination")
    private Pagination pagination;

    public ResultDataPaging(List<?> values, Pagination pagination) {
        this.values = values;
        this.pagination = pagination;
    }

    public List<?> getValues() {
        return values;
    }

    public void setValues(List<?> values) {
        this.values = values;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }
}
