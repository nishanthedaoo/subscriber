package com.niks.asig.subscriber.respository;


import com.niks.asig.subscriber.exception.SubscriptionIdMismatchException;
import com.niks.asig.subscriber.exception.SubscriptionNotFoundException;
import com.niks.asig.subscriber.model.Subscription;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class SubscriptionStore {

    private ConcurrentHashMap<Integer, Subscription> subscriptionsMap = new ConcurrentHashMap<>();

    public Collection<Subscription> getAllSubscription() {
        return subscriptionsMap.values();

    }

    public void addSubscription(Subscription subscription) {
        subscription.setLastUpdate(Instant.now());
        subscriptionsMap.put(subscription.getId(), subscription);

    }

    public Subscription getSubscription(int subscriptionId) {
        Subscription subscription = subscriptionsMap.get(subscriptionId);
        if (subscription != null) {
            return subscription;
        } else {
            throw new SubscriptionNotFoundException();
        }

    }

    public Subscription updateSubscriptionPrice(Subscription subscription, int subscriptionId) {
        if(subscription.getId()!=subscriptionId){
            throw  new SubscriptionIdMismatchException();
        }

        Subscription subscriptionNew = subscriptionsMap.get(subscriptionId);
        if (subscriptionNew != null) {
            subscriptionNew.setMonthlyPrice(subscription.getMonthlyPrice());
            subscriptionNew.setLastUpdate(Instant.now());
            subscriptionsMap.put(subscriptionId, subscriptionNew);
        }else
            throw  new SubscriptionNotFoundException();
        return subscriptionNew;
    }


}
