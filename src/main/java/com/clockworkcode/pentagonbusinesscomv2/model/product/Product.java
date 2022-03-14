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
@Table(name = "Products") //plural !!
public class Product {

    @Id
    @SequenceGenerator(name ="product_sequence" ,sequenceName ="product_sequence" ,allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_sequence")
    private Long productID;


    private String productName;
    private String productDescription;
    private String productSKU;
    private Long productBrandID;
    private Long productCategoryID;
    private Long productInventoryID;
    private Long supplierID;
    private BigInteger productPrice;
    private Long discountID;
    private Timestamp createdAt;
    private Timestamp modifiedAt;
    private Timestamp deletedAt;

}
