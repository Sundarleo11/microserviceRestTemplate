package com.paymentService.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "paymentDetail")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class payment {

    @Id
    @GeneratedValue
    private int paymentId;

    private String paymentStatus;

    private String transactionId;

    private int price;

    private int OrderId;
}
