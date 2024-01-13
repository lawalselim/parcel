package com.example.parcel.Request;
import lombok.Data;

@Data
public class UserCreateRequest {

    private String userName;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private String phoneNumber;
}
