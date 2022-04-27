package com.clockworkcode.pentagonbusinesscomv2.repository;

import com.clockworkcode.pentagonbusinesscomv2.model.product.ProductBrand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductBrandRepository extends JpaRepository<ProductBrand,Long> {
}
