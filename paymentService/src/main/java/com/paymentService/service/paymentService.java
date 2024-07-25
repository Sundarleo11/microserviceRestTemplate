package com.paymentService.service;

import com.paymentService.Entity.payment;
import com.paymentService.Repositry.paymentRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service
public class paymentService {

    @Autowired
    private paymentRepositry paymentRepositorys;


    public payment savePayment(payment payment) {
        System.out.println("payment"+payment);

        //payment.setPaymentStatus(payment.getPaymentStatus());
        payment.setPaymentStatus(ProcessOfPayment());
        payment.setTransactionId(UUID.randomUUID().toString());
        return paymentRepositorys.save(payment);
    }

    private String ProcessOfPayment(){
        return new Random().nextBoolean() ? "success" : "failure";

    }

    public payment getpaymentInfo(int orderId){
        System.out.println("orderID service"+orderId);
        return paymentRepositorys.findByOrderId(orderId);
    }
}
