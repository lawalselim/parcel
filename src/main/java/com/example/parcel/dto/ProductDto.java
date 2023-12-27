package com.example.parcel.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;


@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ProductDto {
    @Min(value = 1, message = "Id must be greater than zero")
    private Long id;
    @NotBlank(message = "Product name is required")
    private String productName;
    @NotBlank(message = "Product description is required")
    private String productDescription;
    @NotBlank(message = "Product Price is require")
    private double productPrice;
    @NotBlank(message = "Product category is required")
    private String productCategory;
    @NotBlank(message = "Product Brand cannot be empty")
    private String productBrand;
    @NotBlank(message = "Image URL cannot be empty")
    private String productImageUrl;
    @NotBlank(message = "Number of items in stock cannot be empty")
    private int stock;



}
