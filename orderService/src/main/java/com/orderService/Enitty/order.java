package com.orderService.Enitty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orderDetail")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class order {

    @Id
    private int id;

    private String ProductName;

    private int qty;

    private int Price;


}
