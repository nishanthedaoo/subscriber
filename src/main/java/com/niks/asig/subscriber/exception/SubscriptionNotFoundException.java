package com.niks.asig.subscriber.exception;

public class SubscriptionNotFoundException extends RuntimeException {

    public  SubscriptionNotFoundException(String msg,Throwable cause){
        super(msg,cause);
    }

    public SubscriptionNotFoundException() {
        super();
    }
}
