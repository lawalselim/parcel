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
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "product_name" )
    private String productName;
    @Column(name = "product_description" )
    private  String productDescription;
    @Column(name = "product_price")
    private String productPrice;
    @Column(name = "product_category")
    private String productCategory;

    /*
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "vendor_id")
    @ToString.Exclude
    private Vendor vendor;
    /*
    @ManyToOne(fetch = FetchType.Lazy, optional = false)
    @OnDelete(action = OneDeleteAction.Cascade)
    @JoinColumn(name= "vendor_id")
    @ToString.Exclude
    private Category category;
    //mapping cart to product because cart item comprises of  product
    //@ManyToOne(MappedBy ="product")
   // @ToString.Exclude
    //private List<Cart> carts;
*/

/*
    @Transient
    public String getShortproductName(){
        if(productName.length() > 40) {
            return productName.substring(0, 40).concat("...");
        }
        return productName;
    }
    @Transient
    public String getShortproductDescription() {

        if (productDescription != null && productDescription.length() > 50) {
            return productDescription.substring(0, 50).concat("...");
        }
        return productDescription;
    }
*/
}
