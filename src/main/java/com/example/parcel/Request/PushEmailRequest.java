package com.example.parcel.Request;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
public class PushEmailRequest {
    @Email
    private String email;

    @NotNull
    private String body;

    @NotNull
    private String title;
}
