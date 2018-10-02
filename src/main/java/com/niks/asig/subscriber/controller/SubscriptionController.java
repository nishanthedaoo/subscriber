package com.niks.asig.subscriber.controller;

import com.niks.asig.subscriber.model.Subscription;
import com.niks.asig.subscriber.respository.SubscriptionStore;
import com.niks.asig.subscriber.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class SubscriptionController {

    public SubscriptionController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @Autowired
    SubscriptionService subscriptionService;

    @RequestMapping(value = "/subscriptions", method = RequestMethod.GET)
    @ResponseBody
    public Collection<Subscription> getAllSubscription(){
    return subscriptionService.getAllSubscription();

    }

    @RequestMapping(value = "/subscriptions/{subscriptionId}", method = RequestMethod.GET)
    @ResponseBody
    public Subscription getSubscription(@PathVariable("subscriptionId") String subscriptionId){

        return subscriptionService.getSubscription(Integer.parseInt(subscriptionId));

    }
    @RequestMapping(value = "/subscriptions/{subscriptionId}", method = RequestMethod.PUT)
    @ResponseBody
    public Subscription updateSubscriptionPrice(@PathVariable("subscriptionId")String subscriptionId,@RequestBody Subscription  subscription){

        return subscriptionService.updateSubscriptionPrice(subscription,Integer.parseInt(subscriptionId));

    }
    @RequestMapping(value = "/subscriptions", method = RequestMethod.POST)
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public void addSubscription(@RequestBody Subscription  subscription){

        subscriptionService.addSubscription(subscription);

    }

}
