package com.niks.asig.subscriber.exception;

import com.niks.asig.subscriber.model.Subscription;

public class SubscriptionIdMismatchException extends RuntimeException {

    public SubscriptionIdMismatchException() {
    }

    public SubscriptionIdMismatchException(String msg, Throwable cause){
        super(msg,cause);

    }
}
