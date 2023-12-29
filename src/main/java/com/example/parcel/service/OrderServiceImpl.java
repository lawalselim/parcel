package com.example.parcel.service;

import com.example.parcel.exception.NotFoundException;
import com.example.parcel.model.Order;
import com.example.parcel.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    @Override
    public List<Order> getAllOrder() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(int id) {
        return orderRepository.findById(id).orElseThrow(() -> new NotFoundException("confirmed order couldn't be found by following id: " + id));
    }

    @Override
    public Order getOrderByOrderNumber(Long orderNumber) {
        return orderRepository.findOrderByOrderNumber(orderNumber);
    }
}
