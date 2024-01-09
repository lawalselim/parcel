package com.example.parcel.dto;

import com.example.parcel.model.Category;
import com.example.parcel.model.Vendor;
import lombok.Data;

@Data
public class ProductUpdateDto {

    private int productId;

    private String productName;

    private String productDescription;

    private double productPrice;

    private String productBrand;

    private String productImageUrl;

    private int stock;

    private Vendor vendor;

    private Category category;

}
