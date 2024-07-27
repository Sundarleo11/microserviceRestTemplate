package com.orderService.controller;

import com.orderService.Core.TransactionalRequest;
import com.orderService.Core.TransactionalResponce;
import com.orderService.Enitty.order;
import com.orderService.Service.orderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order")
public class orderController {


    @Autowired
    private orderService orderService;


    @PostMapping("/BookOrder")
    public order BookOrder(@RequestBody order orderDetail) {

        return orderService.bookOrder(orderDetail);

    }


    @PostMapping("/BookOrderPayment")
    public TransactionalResponce BookOrderPayment(@RequestBody TransactionalRequest request) {

        return orderService.BookOrderPayment(request);

    }




}
