package com.example.parcel.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    private Long id;
    private String description;
    private String destination;
    private String pickupLocation;
    private String phoneNumber;
    private String postCode;
    private String recipient;
    private String date;
    private String Status;
    private String ServiceType;
}

//   sender: {type: Schema.Types.ObjectId, ref: 'User'},
//   description: { type: String, required: true },
//   destination: { type: String, required: true },
//   senderlocation: { type: String, required: true },
//   store: { type: String, required: true },
//   date: { type: String, required: true, default: Date.now },
//   deliverer: { type: String, required: true, default: "" },
//   recievername: { type: String, required: true },
//   status: { type: String, required: true, default: "pending" },
//   phone: { type: Number, required: true },
//   price: { type: Number, required: true },