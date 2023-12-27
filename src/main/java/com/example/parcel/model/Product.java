package com.example.parcel.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private Long id;

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
    @Min(value = 1, message = "{com.eCommerceProject.Min.stock.message}")
    @Column(name = "stock")
    private int stock;
    @Column(name = "product_category")
    private String productCategory;
    @ManyToOne
    private Category category;
    @ManyToOne
    private Vendor vendor;



}
