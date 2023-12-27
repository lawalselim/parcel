package com.example.parcel.service;

import com.example.parcel.model.Cart;

import java.util.List;

public interface CartService {

    Cart getById(int id);
    void deleteById( int id);
    List<Cart> getAll();
    void addtoCart (Cart cart);
}
