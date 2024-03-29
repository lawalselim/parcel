package com.example.parcel.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
@Table(name = "cart")
public class Cart {

    @Id
    private Integer id;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "productName")
    private String productName;

    @Column(name = "productBrand")
    private String productBrand;

    @Column(name = "productDetails")
    private String productDescription;

    @Column(name = "productPrice")
    private Double productPrice;

    @Column(name = "productImageUrl")
    private String productImageUrl;

    @ManyToOne
    private User user;
}
