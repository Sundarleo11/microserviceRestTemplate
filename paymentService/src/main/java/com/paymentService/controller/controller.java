package com.paymentService.controller;

import com.paymentService.Entity.payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("payment")
public class controller {

    @Autowired
    private com.paymentService.service.paymentService paymentService;

    @PostMapping("/doPayment")
    public payment Dopayment(@RequestBody payment payment){

        return paymentService.savePayment(payment);

    }

}
