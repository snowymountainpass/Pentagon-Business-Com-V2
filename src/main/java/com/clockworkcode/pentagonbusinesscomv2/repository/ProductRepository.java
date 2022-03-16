package com.clockworkcode.pentagonbusinesscomv2.repository;

import com.clockworkcode.pentagonbusinesscomv2.model.product.Product;
import com.clockworkcode.pentagonbusinesscomv2.model.product.ProductBrand;
import com.clockworkcode.pentagonbusinesscomv2.model.product.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    List<Product> getProductsByProductName(String productName);

    List<Product> getProductsByProductCategory(ProductCategory productCategory);

    List<Product> getProductsByProductBrand(ProductBrand productBrand);

}
