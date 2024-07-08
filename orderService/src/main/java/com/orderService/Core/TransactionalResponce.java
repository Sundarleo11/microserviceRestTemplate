package com.orderService.Core;



import com.orderService.Enitty.order;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TransactionalResponce {

    private  order orders;

    private String transactionId;

    private int price;

    private String message;
}
