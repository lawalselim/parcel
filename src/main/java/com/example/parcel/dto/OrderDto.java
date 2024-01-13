package com.example.parcel.dto;

import com.example.parcel.model.Address;
import com.example.parcel.model.User;
import com.example.parcel.model.Vendor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    private Integer id;
    private Integer orderNumber;
    private String productName;
    private String productBrand;
    private String productDescription;
    private String productPrice;
    private String productImageUrl;
    private Address address;
    private Vendor vendor;
    private User user;

}

