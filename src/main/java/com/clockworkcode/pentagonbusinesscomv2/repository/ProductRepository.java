package com.clockworkcode.pentagonbusinesscomv2.repository;

import com.clockworkcode.pentagonbusinesscomv2.model.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
}
