package com.orderService.Service;

import com.orderService.Core.TransactionalRequest;
import com.orderService.Core.TransactionalResponce;
import com.orderService.Core.payment;
import com.orderService.Enitty.order;
import com.orderService.Repositry.OrderRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RefreshScope
public class orderService {

    @Autowired
    private OrderRepositry orderRepositry;

    @Autowired
    @Lazy
    private RestTemplate restTemplate;


    @Value("${microservice.payment-service.endpoints.endpoint.uri}")
    private String TemplateURl;


    public order bookOrder(order orderDetail) {

        return this.orderRepositry.save(orderDetail);
    }

     public TransactionalResponce BookOrderPayment(TransactionalRequest request) {

        System.out.println("request"+request);

        String resStatus = "";

        order order = request.getOrders();

        payment payments = request.getPayments();
        payments.setOrderId(order.getId());
        payments.setPrice(order.getPrice());
        System.out.println("payments"+payments);

      //  RestTemplate restTemplate = new RestTemplate();

       // payment paymentResponce = restTemplate.postForObject("http://localhost:9092/payment/doPayment", payments, payment.class);
       //payment-service
       // payment paymentResponce = restTemplate.postForObject("http://PAYMENT-SERVICE/payment/doPayment", payments, payment.class);
         payment paymentResponce = restTemplate.postForObject(TemplateURl, payments, payment.class);
        orderRepositry.save(order);

        resStatus = paymentResponce.getPaymentStatus().equals("success") ? "Successful TransactionalRequest" : "Failure TransactionalRequest";

        return new TransactionalResponce(order, paymentResponce.getTransactionId(), paymentResponce.getPrice(), resStatus);

    }


}
