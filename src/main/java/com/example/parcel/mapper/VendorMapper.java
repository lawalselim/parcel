package com.example.parcel.mapper;

import com.example.parcel.dto.VendorDto;
import com.example.parcel.model.Vendor;

public class VendorMapper {
    public static VendorDto MapToVendorDto (Vendor vendor){
        return new VendorDto(
                vendor.getId(),
                vendor.getFullName()
                //vendor.getProduct()
        );
    }
    public static Vendor mapToVendor (VendorDto vendorDto){
        return new Vendor(
                vendorDto.getID(),
                vendorDto.getFullName()
               // vendorDto.getProduct()
        );
    }
}
