package com.orderService.Repositry;

import com.orderService.Enitty.order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepositry extends JpaRepository<order, Integer> {
}
