package com.example.parcel.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RecipientDto {

        private Long id;
        private String firstName;
        private String lastName;
        private String phoneNumber;
        private String postCode;
}
