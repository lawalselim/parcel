package com.example.parcel.dto;

import com.example.parcel.model.User;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class UserViewDto implements Serializable {

    private static final Long serialVersionID = 1L;

   private final String email;
   private final String password;

   private UserViewDto(String email, String password){
       this.email = email;
       this.password = password;
   }

   public static UserViewDto of (User user){
       return new UserViewDto(user.getEmail(), user.getPassword());
   }
}
