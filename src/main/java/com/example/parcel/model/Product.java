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

    @Column(name = "productName" )
    private String productName;
    @Column(name = "productBrand")
    private String productBrand;
    @Column(name = "productDescription" )
    private  String productDescription;
    @Column(name = "productPrice")
    private double productPrice;
    @Column(name = "productImageUrl")
    private String productImageUrl;
    @Min(value = 1, message = "{com.example.parcel.Min.stock.message}")
    @Column(name = "stock")
    private Integer stock;
    @ManyToOne
    private Category category;
    @ManyToOne
    private Vendor vendor;
    @Column(name = "favoriteNumber")
    @Min(value = 0)
    private int favoriteNumber =0;


    public Product(String productName, String productBrand, String productDescription, double productPrice, Integer stock, String productImageUrl) {
        this.productName = productName;
        this.productBrand = productBrand;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.stock = stock;
        this.productImageUrl = productImageUrl;
    }
}
