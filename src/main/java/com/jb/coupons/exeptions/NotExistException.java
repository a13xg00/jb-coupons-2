package com.jb.coupons.exeptions;

public class NotExistException extends Exception {
    public NotExistException(String message){
        super(message);
    }
}
