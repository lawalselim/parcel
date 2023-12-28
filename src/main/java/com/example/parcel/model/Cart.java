package com.example.parcel.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cart")
public class Cart {

    @Id
    private Integer id;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "productName")
    private String productName;

    @Column(name = "productBrand")
    private String productBrand;

    @Column(name = "productDetails")
    private String productDescription;

    @Column(name = "productPrice")
    private double productPrice;

    @Column(name = "productImageUrl")
    private String productImageUrl;

    @ManyToOne
    private Vendor vendor;
}
