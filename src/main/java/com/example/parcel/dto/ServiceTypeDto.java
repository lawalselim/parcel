package com.example.parcel.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ServiceTypeDto {

    private Long id;
    private String serviceName; // name can be
    private String servicePrice;
    private String serviceType; // Type can be 1st class, 2nd class, 3rd class or Premium
    private String serviceDescription;

}
