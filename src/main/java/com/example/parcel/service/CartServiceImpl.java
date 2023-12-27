package com.example.parcel.service;

import com.example.parcel.exception.NotFoundException;
import com.example.parcel.model.Cart;
import com.example.parcel.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements  CartService{

    private final CartRepository cartRepository;

    @Override
    public Cart getById(int id){
        Optional<Cart> cart = cartRepository.findById(id);
        return cart.orElseThrow(() -> new NotFoundException("cart Not Found by Id: " + id));
    }

    @Override
    public void deleteById(int id){
        cartRepository.deleteById(id);
    }

    @Override
    public List<Cart> getAll() {
        return cartRepository.findAll();
    }

    @Override
    public void addtoCart(Cart cart) {
        cartRepository.save(cart);
    }

}
