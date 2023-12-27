package com.example.parcel.mapper;

import com.example.parcel.dto.DriverDto;

public class DriverMapper {
    public static DriverDto mapToDriverDto(Driver driver){
        return new DriverDto(
                driver.getId(),
                driver.getFirstName(),
                driver.getLastName(),
                driver.getPhoneNumber(),
                driver.getEmail(),
                driver.getPostCode(),
                driver.getAddress(),
                driver.getPassword(),
                driver.getConfirmPassword()
        );
    }
    public static Driver mapToDriver(DriverDto driverDto){
        return new Driver (
                driverDto.getId(),
                driverDto.getFirstName(),
                driverDto.getLastName(),
                driverDto.getEmail(),
                driverDto.getPhoneNumber(),
                driverDto.getPostCode(),
                driverDto.getAddress(),
                driverDto.getPassword(),
                driverDto.getConfirmPassword()
        );
    }
}
