package com.example.parcel.repository;

import com.example.parcel.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {

    List<Product> getByproductName(String productName);
    List<Product> getByproductBrand(String productBand);

    void deleteBy(int id);

}
