package com.example.parcel.model;


import jakarta.persistence.*;
import lombok.*;
import java.util.List;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "vendors")
public class Vendor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "full_name", nullable = false )
    private String fullName;
    /*mapping product to vendor as product are created by vendor which are available to be sold to the user
    @OneToMany(mappedBy = "vendor")
    @ToString.Exclude
    private List <Product> product;

     */
}
