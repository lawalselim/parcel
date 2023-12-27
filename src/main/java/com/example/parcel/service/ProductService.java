package com.example.parcel.service;
import com.example.parcel.dto.ProductDto;
import com.example.parcel.model.Product;
import com.example.parcel.model.Cart;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface ProductService {
    ProductDto getProductById( Long productId);
    ProductDto updateProduct( ProductDto productDto);
    ProductDto createProduct (ProductDto productDto);
    void deleteByid (int id);
    List<ProductDto> getByproductName (String productName);

    List<Product> getAll();
    Product getById(int id);
    List<Product> getByproductBrand(String productBrand);
    void deleteById(int id);
    void updateByProductDetails(int productId, String productDetails);
    List<Product> slice(Pageable pageable);
    //List<ProductViewDto> getDto();


    Cart addToCart(int id);
    List<Cart> getCart();
    void removeFromCart(int id);
    //ConfirmedOrder confirmCart(ConfirmCartRequest confirmCartRequest);
    //List<ConfirmedOrder> getAllConfirmedOrder();
    //ConfirmedOrder getConfirmedOrderById(int id);
   //ConfirmedOrder getConfirmedOrderByOrderNumber(Long orderNumber);
    Map<Integer, Object> searchByProduct(String productName);
    void addFavorite(int productId);
    int getNumberOfFavorite(int productId);
    void removeFromFavorites(int productId);




}
