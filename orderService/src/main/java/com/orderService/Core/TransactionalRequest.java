package com.orderService.Core;



import com.orderService.Enitty.order;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TransactionalRequest {

     private order orders;
     private payment payments;

}
