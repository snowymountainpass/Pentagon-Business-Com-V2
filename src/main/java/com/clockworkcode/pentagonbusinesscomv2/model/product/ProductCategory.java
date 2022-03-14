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
@Table(name = "ProductCategories") //plural !!
public class ProductCategory {


    @Id
    @SequenceGenerator(name ="productcategory_sequence" ,sequenceName ="productcategory_sequence" ,allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "productcategory_sequence")
    private Long productCategoryID;

    private String productCategoryName;
    private String productCategoryDescription;
    private Timestamp createdAt;
    private Timestamp modifiedAt;
    private Timestamp deletedAt;
}
