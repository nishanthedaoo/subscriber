package com.niks.asig.subscriber;

import com.google.common.eventbus.Subscribe;
import com.niks.asig.subscriber.model.Subscription;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Instant;

import static io.restassured.RestAssured.basic;
import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = { SubscriberApplication.class }, webEnvironment
        = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class SubscriptionIntegrationTest {

    @Test
    public void whenGetAllSubscription_thenOK() {
        final String URL
                = "http://localhost:8080/api/subscriptions";
        RestAssured.authentication = basic("user", "user");
        Response response = RestAssured.get(URL);

        assertEquals(HttpStatus.OK.value(), response.getStatusCode());
    }

    @Test
    public void whenupdateSubscriptionPrice_thenOK() {
         final String URL
                = "http://localhost:8080/api/subscriptions/1";
        Subscription subscription= new Subscription(1,"Sub1",222, Instant.now());
        RestAssured.authentication = basic("user", "user");
        Response response = RestAssured.given().contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(subscription).put(URL);

        assertEquals(HttpStatus.OK.value(), response.getStatusCode());
        assertEquals(subscription.getName(),response.jsonPath().get("name") );
        assertEquals(String.valueOf(subscription.getMonthlyPrice()),response.jsonPath().get("monthlyPrice").toString());
    }
    @Test
    public void whenAddSubscription_thenCREATED() {
        final String URL
                = "http://localhost:8080/api/subscriptions";
        Subscription subscription= new Subscription(1,"Sub1",222, Instant.now());
        RestAssured.authentication = basic("user", "user");
        Response response = RestAssured.given().contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(subscription).post(URL);

        assertEquals(HttpStatus.CREATED.value(), response.getStatusCode());

    }
    @Test
    public void whenGetNotExistSubscriptionById_thenNotFound() {
        final String URL
                = "http://localhost:8080/api/subscriptions/2123";
        RestAssured.authentication = basic("user", "user");
        Response response = RestAssured.get(URL);
        assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatusCode());
    }
    @Test
    public void whenupdateSubscriptionIdMismatch_thenMismatch() {
        final String URL
                = "http://localhost:8080/api/subscriptions/2";
        Subscription subscription= new Subscription(1,"Sub1",222, Instant.now());
        RestAssured.authentication = basic("user", "user");
        Response response = RestAssured.given().contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(subscription).put(URL);

        assertEquals(HttpStatus.BAD_REQUEST.value(), response.getStatusCode());

    }
}
