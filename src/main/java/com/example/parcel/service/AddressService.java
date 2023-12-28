package com.example.parcel.service;

import com.example.parcel.model.Address;

import java.util.List;

public interface AddressService {

    Address add(Address address);
    List<Address>getAll();
    void deleteById(int id);
    List<Address> getAddressByUserId(int userId);

    Address getById(int id);

}
