package com.example.parcel.dto;


import lombok.*;


@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ProductDto {


    private String productName;

    private String productDescription;

    private double productPrice;

    private String productBrand;

    private String productImageUrl;

    private Integer stock;



}
