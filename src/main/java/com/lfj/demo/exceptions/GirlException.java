package com.lfj.demo.exceptions;

public class GirlException extends RuntimeException{

    private String errCode;

    public GirlException(String errCode, String errMsg) {
        super(errMsg);
        this.errCode = errCode;
    }

    public String getErrCode() {
        return errCode;
    }
}
