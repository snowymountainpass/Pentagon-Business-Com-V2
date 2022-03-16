package com.clockworkcode.pentagonbusinesscomv2.service;

import com.clockworkcode.pentagonbusinesscomv2.model.product.Product;
import com.clockworkcode.pentagonbusinesscomv2.model.product.ProductBrand;
import com.clockworkcode.pentagonbusinesscomv2.repository.ProductBrandRepository;
import com.clockworkcode.pentagonbusinesscomv2.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductDBService {

    private final ProductRepository productRepository;
    private final ProductBrandRepository productBrandRepository;

    @Autowired
    public ProductDBService(ProductRepository productRepository,ProductBrandRepository productBrandRepository) {
        this.productRepository = productRepository;
        this.productBrandRepository = productBrandRepository;
    }

    public List<Product> getAllProducts(){return productRepository.findAll();}

    public List<Product> getProductsByName(String productName){
        return productRepository.getProductsByProductName(productName);
    }

    public List<Product> getProductsByProductCategory(String productCategory){
        
    }

    public List<Product> getProductsByBrandName(String productBrandName){
        ProductBrand productBrand = productBrandRepository.getProductBrandByProductBrandName(productBrandName);
        return productRepository.getProductsByProductBrand(productBrand);
    }



}
