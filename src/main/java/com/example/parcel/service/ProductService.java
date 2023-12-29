package com.example.parcel.service;
import com.example.parcel.dto.ProductDto;
import com.example.parcel.dto.ProductUpdateDto;
import com.example.parcel.model.Product;
import com.example.parcel.model.Cart;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface ProductService {

    List<Product> getAll();
    ProductDto createProduct(ProductDto productDto);

    void  updateByProductDetails(ProductUpdateDto productUpdateDto);
    Product getById(int id);
    List<Product> getByproductName(String productName);
    List<Product> getByproductBrand(String productBrand);
    void deleteById(int id);

    List<Product> slice(Pageable pageable);
    Cart addToCart(int id);
    List<Cart> getCart();
    void removeFromCart(int id);

    Map<Integer, Object> searchByProduct(String productName);
   void addFavorite(int productId);
   int getNumberOfFavorite(int productId);
   void removeFromFavorites(int productId);




}
