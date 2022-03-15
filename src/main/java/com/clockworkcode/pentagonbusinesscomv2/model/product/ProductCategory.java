package com.clockworkcode.pentagonbusinesscomv2.model.product;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity(name = "ProductCategory") //singular !!
@Table(name = "product_categories") //plural !!
public class ProductCategory {


    @Id
    @SequenceGenerator(name ="productcategory_sequence" ,sequenceName ="productcategory_sequence" ,allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "productcategory_sequence")
    private Long productCategoryID;

    @Column(nullable = false,columnDefinition = "text")
    private String productCategoryName;
    @Column(nullable = false,columnDefinition = "text")
    private String productCategoryDescription;
    @Column(nullable = false)
    private Timestamp createdAt;
    @Column(nullable = false)
    private Timestamp modifiedAt;
    @Column(nullable = false)
    private Timestamp deletedAt;


    @OneToOne(mappedBy = "productCategory")
    private Product product;


}
