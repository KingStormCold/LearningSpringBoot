package com.store_phone.response;

public class CommonResponse<T> {
    private T data;
    public T getData() { return data;}
    public void setData(T data) {
        this.data = data;
    }
    public CommonResponse() {}
    public CommonResponse(T data) {this.data = data;}
}
