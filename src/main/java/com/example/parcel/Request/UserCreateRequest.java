package com.example.parcel.Request;
import lombok.Data;

@Data
public class UserCreateRequest {
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String phoneNumber;
    private String email;
}
