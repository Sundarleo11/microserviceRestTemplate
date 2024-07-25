package com.paymentService.controller;

import com.paymentService.Entity.payment;
import com.paymentService.service.paymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class controller {

    @Autowired
    private paymentService paymentServices;

    @PostMapping("/doPayment")
    public payment Dopayment(@RequestBody payment payment){

        return paymentServices.savePayment(payment);

    }

    @GetMapping("/order/{orderId}")
    public payment getOrderDetail(@PathVariable("orderId") int orderId){
        System.out.println("orderID controller"+orderId);
        return paymentServices.getpaymentInfo(orderId);
    }

}
