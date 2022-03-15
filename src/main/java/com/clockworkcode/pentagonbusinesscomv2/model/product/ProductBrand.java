package com.clockworkcode.pentagonbusinesscomv2.model.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity(name = "ProductBrand") //singular !!
@Table(name = "product_brands") //plural !!
public class ProductBrand {

    @Id
    @SequenceGenerator(name ="productbrand_sequence" ,sequenceName ="productbrand_sequence" ,allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "productbrand_sequence")
    private Long productBrandID;

    private String productBrandName;
    private String productBrandDescription;

}
