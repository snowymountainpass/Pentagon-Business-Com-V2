package com.clockworkcode.pentagonbusinesscomv2.model.product;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity(name = "ProductCategory")
@Table(name = "product_categories")
public class ProductCategory {


    @Id
    @SequenceGenerator(name ="productcategory_sequence" ,sequenceName ="productcategory_sequence" ,allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "productcategory_sequence")
    private Long productCategoryID;

    @Column(nullable = false,columnDefinition = "text")
    private String productCategoryName;
    @Column(nullable = false,columnDefinition = "text")
    private String productCategoryDescription;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "productCategory",orphanRemoval = true)
    private Set<Product> products=new HashSet<>();

    public ProductCategory(String productCategoryName, String productCategoryDescription) {
        this.productCategoryName = productCategoryName;
        this.productCategoryDescription = productCategoryDescription;
    }

    public void addProducts(Set<Product> productsSet){
        this.products.addAll(productsSet);
        productsSet.forEach(product -> product.setProductCategory(this));

    }

}
