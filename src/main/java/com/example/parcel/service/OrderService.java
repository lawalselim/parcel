package com.example.parcel.service;

import com.example.parcel.model.Order;

import java.util.List;

public interface OrderService {
    List<Order> getAllOrder();
    Order getOrderById(int id);
    Order getOrderByOrderNumber(Long orderNumber);
}
