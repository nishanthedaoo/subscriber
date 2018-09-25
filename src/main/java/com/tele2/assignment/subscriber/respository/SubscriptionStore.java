package com.tele2.assignment.subscriber.respository;


import com.tele2.assignment.subscriber.model.Subscription;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
@Repository
public class SubscriptionStore {

    private ConcurrentHashMap<Integer,Subscription> subscriptionsMap =new ConcurrentHashMap<>();

    public Collection<Subscription> getAllSubscription(){
        return  subscriptionsMap.values();

    }

    public void addSubscription(Subscription subscription){
        subscriptionsMap.put(subscription.getId(),subscription);

    }

    public  Subscription getSubscription(int subscriptionId){
        return  subscriptionsMap.get(subscriptionId);
    }

    public  Subscription updateSubscriptionPrice(Subscription subscription,int subscriptionId){

        Subscription   subscriptionNew= subscriptionsMap.get(subscriptionId);
        subscriptionNew.setMonthlyPrice(subscription.getMonthlyPrice());
        return  subscriptionsMap.put(subscriptionId,subscriptionNew);
    }


}
