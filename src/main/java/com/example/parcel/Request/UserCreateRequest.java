package com.example.parcel.Request;
import lombok.Data;

@Data
public class UserCreateRequest {

    private String userName;
    private String password;
    private String email;
}
