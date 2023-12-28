package com.example.parcel.repository;


import com.example.parcel.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User getById(int id);

    @Query("from User where email=:email")
    User findByEmail(String email);
}


// User findByEmail(String email);
// User findUserById(int userId);
//add other custom queries here