package com.rs.demo.basemvp.bean;

import com.google.gson.annotations.SerializedName;


public class BaseResult<T> {

   private String message;
   private int status;
   private String code;

    private T result;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "HttpResult{" +
                "message='" + message + '\'' +
                ", status=" + status +
                ", code='" + code + '\'' +
                ", result=" + result +
                '}';
    }
}
