package com.clockworkcode.pentagonbusinesscomv2.model.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity(name = "Product") //singular !!
@Table(name = "products") //plural !!
public class Product {

    @Id
    @SequenceGenerator(name ="product_sequence" ,sequenceName ="product_sequence" ,allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_sequence")
    private Long productID;

    @Column(nullable = false,columnDefinition = "text")
    private String productName;
    @Column(nullable = false,columnDefinition = "text")
    private String productDescription;
    @Column(nullable = false,columnDefinition = "text")
    private String productSKU;


    private Long productBrandID;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_categoryID",referencedColumnName = "product_categoryID")
    private ProductCategory productCategory;

    private Long productInventoryID;

    private Long supplierID;

    private BigInteger productPrice;

    private Long discountID;

    @Column(nullable = false)
    private Timestamp createdAt;
    @Column(nullable = false)
    private Timestamp modifiedAt;
    @Column(nullable = false)
    private Timestamp deletedAt;

}
