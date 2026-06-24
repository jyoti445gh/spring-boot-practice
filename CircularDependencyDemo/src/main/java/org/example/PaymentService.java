package org.example;

import org.springframework.stereotype.Component;

@Component
public class PaymentService {

    public PaymentService() {
    }

    public void pay() {
        System.out.println("Payment done");

        // Not its responsibility
        //orderService.getOrderDetails();
    }
}