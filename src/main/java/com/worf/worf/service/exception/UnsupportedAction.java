package com.worf.worf.service.exception;

public class UnsupportedAction extends RuntimeException{
    public UnsupportedAction(String msg, Throwable throwable){
        super(msg,throwable);
    }
}
