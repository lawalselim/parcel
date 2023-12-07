package com.example.parcel.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



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
    private String productPrice;
    @NotBlank(message = "Product category is required")
    private String productCategory;
    //private List Cart;


}
