package com.tele2.assignment.subscriber;

import com.tele2.assignment.subscriber.model.Subscription;
import com.tele2.assignment.subscriber.respository.SubscriptionStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.Instant;


@Component
public class AppStartupRunner implements ApplicationRunner {
    @Autowired
    SubscriptionStore subscriptionStore;
    private static final Logger LOG =
            LoggerFactory.getLogger(AppStartupRunner.class);



    @Override
    public void run(ApplicationArguments args) throws Exception {
        LOG.info("Application started");
        Subscription s1= new Subscription(1,"Sub1",123,Instant.now());
        Subscription s2= new Subscription(2,"Sub2",13323,Instant.now());
        Subscription s3= new Subscription(3,"Sub3",12443,Instant.now());
        subscriptionStore.addSubscription(s1);
        subscriptionStore.addSubscription(s2);
        subscriptionStore.addSubscription(s3);

    }
}

