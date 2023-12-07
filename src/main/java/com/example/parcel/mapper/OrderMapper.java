package com.example.parcel.mapper;

import com.example.parcel.dto.OrderDto;
import com.example.parcel.model.Order;

public class OrderMapper {
    public static OrderDto mapToOrderDto(Order order){
       return new OrderDto (
               order.getId(),
               order.getDescription(),
               order.getDestination(),
               order.getPickupLocation(),
               order.getPhoneNumber(),
               order.getPostCode(),
               order.getRecipient(),
               order.getDate(),
               order.getServiceType(),
               order.getDescription()
       );
    }
    public static Order mapToPackage(OrderDto orderDto){
         return new Order(
                 orderDto.getId(),
                 orderDto.getDescription(),
                 orderDto.getPickupLocation(),
                 orderDto.getPhoneNumber(),
                 orderDto.getDestination(),
                 orderDto.getPostCode(),
                 orderDto.getStatus(),
                 orderDto.getDate(),
                 orderDto.getServiceType(),
                 orderDto.getRecipient()
         );
    }
}
