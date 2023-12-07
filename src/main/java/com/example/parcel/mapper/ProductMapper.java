package com.example.parcel.mapper;

import com.example.parcel.dto.ProductDto;
import com.example.parcel.model.Product;

public class ProductMapper {

    public static ProductDto mapToProductDto(Product product){
        return new ProductDto(
                product.getId(),
                product.getProductName(),
                product.getProductDescription(),
                product.getProductPrice(),
                product.getProductCategory()
               // product.getCarts()
        );
    }

    public static Product mapToProduct(ProductDto productDto){
        return new Product(
                productDto.getId(),
                productDto.getProductName(),
                productDto.getProductDescription(),
                productDto.getProductPrice(),
                productDto.getProductCategory()

               // productDto.getCarts()
        );
    }

}
