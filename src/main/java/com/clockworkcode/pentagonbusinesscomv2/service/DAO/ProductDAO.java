package com.clockworkcode.pentagonbusinesscomv2.service.DAO;

import com.clockworkcode.pentagonbusinesscomv2.model.Product;

import java.util.List;

public interface ProductDAO {

    List<Product> getAllProducts();

    List<Product> getAllProductsByCategory(String productCategory);

    List<Product> getProductsByName(String productName);

    List<Product> getProductsPriceDecreasing();

    List<Product> getProductsPriceIncreasing();



}
