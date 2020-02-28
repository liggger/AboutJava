package com.liggger.strip.service;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class StripeService {

    @Value("${stripe.key.secret}")
    private String API_SECRET_KEY;


    public StripeService() {
    }

    public String createCustomer(String email, String token) {

        String id = null;

        try {
            Stripe.apiKey = API_SECRET_KEY;
            Map<String, Object> customerParams = new HashMap<>();
            customerParams.put("description", "Customer for " + email);
            customerParams.put("email", email);
            customerParams.put("source", token);

            Customer customer = Customer.create(customerParams);
            id = customer.getId();

        } catch (StripeException e) {
            e.printStackTrace();
        }

        return id;
    }

    public Plan createPlan() throws StripeException {
        Map<String, Object> product = new HashMap<>();
        product.put("name", "Gold special");
        Map<String, Object> params = new HashMap<>();
        params.put("amount", 5000);
        params.put("currency", "gbp");
        params.put("interval", "month");
        params.put("product", product);

        Plan plan = Plan.create(params);
        return plan;
    }

    public String createSubscription(String customerId, String plan, String coupon) {

        String subscriptionId = null;

        try {
            Stripe.apiKey = API_SECRET_KEY;
            Plan plan1 = createPlan();

            Map<String, Object> item = new HashMap<>();

//            item.put("plan", plan);

            item.put("plan", "plan_GoucvhBN2R5C3Q");

            Map<String, Object> items = new HashMap<>();
            items.put("0", item);

            Map<String, Object> params = new HashMap<>();
            params.put("customer", customerId);
            params.put("items", items);

            if (!coupon.isEmpty()) {
                params.put("coupon", coupon);
            }

            Subscription subscription = Subscription.create(params);

            subscriptionId = subscription.getId();
        } catch (StripeException e) {
            e.printStackTrace();
        }

        return subscriptionId;
    }

    public boolean cancelSubscription(String subscriptionId) {

        boolean subscriptionStatus;

        try {
            Subscription subscription = Subscription.retrieve(subscriptionId);
            subscription.cancel();
            subscriptionStatus = true;
        } catch (StripeException e) {
            e.printStackTrace();
            subscriptionStatus = false;
        }

        return subscriptionStatus;
    }

    public Coupon retrieveCoupon(String code) {
        try {
            Stripe.apiKey = API_SECRET_KEY;
            return Coupon.retrieve(code);
        } catch (StripeException e) {
            e.printStackTrace();
        }

        return null;
    }

    public String createCharge(String email, String token, int amount) {

        String chargeId = null;

        try {
            Stripe.apiKey = API_SECRET_KEY;

            Map<String, Object> chargeParams = new HashMap<>();
            chargeParams.put("description","Charge for "+email);
            chargeParams.put("currency","usd");
            chargeParams.put("amount",amount);
            chargeParams.put("source",token);

            Charge charge = Charge.create(chargeParams);
            chargeId = charge.getId();
        } catch (StripeException e) {
            e.printStackTrace();
        }

        return chargeId;
    }
}
