package com.example.parcel.repository;

import com.example.parcel.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {
 Order findOrderByOrderNumber(Long orderNumber);
}
