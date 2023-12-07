package com.example.parcel.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="orders")
public class Order {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "description")
    private String description;
    @Column(name = "pickup_location")
    private String pickupLocation;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "destination")
    private String destination;
    @Column(name = "post_code")
    private String postCode;
    @Column(name = "recipient")
    private String recipient;
    @Column(name = "date")
    private String date;
    @Column(name = "status")
    private String Status;
    @Column(name = "service_type")
    private String serviceType;
}
