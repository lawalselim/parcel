package com.example.parcel.controller;

import com.example.parcel.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products/")
@RequiredArgsConstructor
@CrossOrigin
public class OrderController {

    private final OrderService orderService;


    @GetMapping("getAllConfirmedCart")
    public ResponseEntity<?> getAllOrder() {
        return ResponseEntity.ok(orderService.getAllOrder());
    }

    @GetMapping("getOrderById/{id}")
    public ResponseEntity<?> getConfirmedOrderById(@PathVariable int id) {
        return ResponseEntity.ok(orderService.getOrderById(id));
    }

    @GetMapping("getOrderByOrderNumber/{orderNumber}")
    public ResponseEntity<?> getOrderByOrderNumber(@PathVariable Long orderNumber) {
        return ResponseEntity.ok(orderService.getOrderByOrderNumber(orderNumber));
    }
}
