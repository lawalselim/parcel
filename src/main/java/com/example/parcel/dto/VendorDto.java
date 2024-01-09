package com.example.parcel.dto;

import com.example.parcel.model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VendorDto {


    @NotNull
    private String fullName;


    private String profilePictureUrl;

    @NotNull
    @Email
    private String email;

    private Product  product;

    public VendorDto(String fullName, String profilePictureUrl, String email){
        this.fullName = fullName;
        this.profilePictureUrl = profilePictureUrl;
        this.email = email;
    }
}
