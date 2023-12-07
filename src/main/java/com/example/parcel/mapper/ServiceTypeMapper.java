package com.example.parcel.mapper;
import com.example.parcel.dto.ServiceTypeDto;
import com.example.parcel.model.ServiceType;
public class ServiceTypeMapper {
    public static ServiceTypeDto mapToServiceTypeDto (ServiceType serviceType){
        return new ServiceTypeDto(
                serviceType.getId(),
                serviceType.getServiceName(),
                serviceType.getServicePrice(),
                serviceType.getServiceType(),
                serviceType.getServiceDescription()
        );
    }

    public static ServiceType mapToServiceType( ServiceTypeDto serviceTypeDto){
        return new ServiceType(
                serviceTypeDto.getId(),
                serviceTypeDto.getServiceName(),
                serviceTypeDto.getServicePrice(),
                serviceTypeDto.getServiceType(),
                serviceTypeDto.getServiceDescription()
        );
    }

}
