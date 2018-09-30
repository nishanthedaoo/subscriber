package com.niks.asig.subscriber.service;

import com.niks.asig.subscriber.model.Subscription;
import com.niks.asig.subscriber.respository.SubscriptionStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.Collection;

@Service
public class SubscriptionService {
    @Autowired
    SubscriptionStore subscriptionStore;
    @Transactional(readOnly = true)
    public Collection<Subscription> getAllSubscription(){
        return  subscriptionStore.getAllSubscription();

    }
    @Transactional
    public void addSubscription(Subscription subscription){
        subscriptionStore.addSubscription(subscription);

    }
    @Transactional(readOnly = true)
    public  Subscription getSubscription(int subscriptionId){

        return  subscriptionStore.getSubscription(subscriptionId);
    }
    @Transactional
    public  Subscription updateSubscriptionPrice(Subscription subscription,int subscriptionId){

        return  subscriptionStore.updateSubscriptionPrice(subscription,subscriptionId);
    }
}
