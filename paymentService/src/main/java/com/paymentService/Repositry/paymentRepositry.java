package com.paymentService.Repositry;

import com.paymentService.Entity.payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface paymentRepositry extends JpaRepository<payment, Integer> {

          payment findByOrderId(int orderId);
}
