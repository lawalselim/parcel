package com.example.parcel.service;
import com.example.parcel.dto.ProductDto;

public interface ProductService {
    ProductDto getProductById( Long productId);
    ProductDto updateProduct( ProductDto productDto);
    ProductDto createProduct (ProductDto productDto);

}
