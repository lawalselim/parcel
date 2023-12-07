package com.example.parcel.repository;


import com.example.parcel.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    User findUserById(Long userId);
    //add other custom queries here
}
