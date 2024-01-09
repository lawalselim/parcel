package com.example.parcel.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "product_name" )
    private String productName;
    @Column(name = "product_brand")
    private String productBrand;
    @Column(name = "product_description" )
    private  String productDescription;
    @Column(name = "product_price")
    private double productPrice;
    @Column(name = "image")
    private String productImageUrl;
    @Min(value = 1, message = "{com.example.parcel.Min.stock.message}")
    @Column(name = "stock")
    private int stock;
    @ManyToOne
    private Category category;
    @ManyToOne
    private Vendor vendor;
    @Column(name = "favoriteNumber")
    @Min(value = 0)
    private int favoriteNumber = 0;


    public Product(String productName, String productBrand, String productDescription, double productPrice, int stock, String productImageUrl) {
        this.productName = productName;
        this.productBrand = productBrand;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.stock = stock;
        this.productImageUrl = productImageUrl;
    }
}
