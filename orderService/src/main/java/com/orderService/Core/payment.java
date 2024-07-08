package com.orderService.Core;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class payment {

    private int paymentId;

    private String paymentStatus;

    private String transactionId;

    private int price;

    private int OrderId;
}
