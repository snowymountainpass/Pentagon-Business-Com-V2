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

@Entity(name = "ProductBrand")
@Table(name = "productbrands")
public class ProductBrand {

    @Id
    @SequenceGenerator(name ="productbrand_sequence" ,sequenceName ="productbrand_sequence" ,allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "productbrand_sequence")
    private Long id;

    private String productBrandName;
    private String productBrandDescription;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "productBrand",orphanRemoval = true)
    private Set<Product> products = new HashSet<>();

    public ProductBrand(String productBrandName, String productBrandDescription) {
        this.productBrandName = productBrandName;
        this.productBrandDescription = productBrandDescription;
    }

    public void addProduct(Product product1) {
        this.products.add(product1);
        product1.setProductBrand(this);
    }

    public void addProducts(Set<Product> productsSet){
        this.products.addAll(productsSet);
        productsSet.forEach(product -> product.setProductBrand(this));
    }

}
