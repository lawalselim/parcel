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
@Table(name ="servicetype")
public class ServiceType {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "service_name")
    private String serviceName; // name can be
    @Column(name = "service_price")
    private String servicePrice;
    @Column(name = "service_type")
    private String serviceType; // Type can be 1st class, 2nd class, 3rd class or Premium
    @Column(name = "service_description")
    private String serviceDescription;

}
