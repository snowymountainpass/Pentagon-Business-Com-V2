package com.clockworkcode.pentagonbusinesscomv2.service;

import com.clockworkcode.pentagonbusinesscomv2.model.product.Product;
import com.clockworkcode.pentagonbusinesscomv2.model.product.ProductBrand;
import com.clockworkcode.pentagonbusinesscomv2.model.product.ProductCategory;
import com.clockworkcode.pentagonbusinesscomv2.repository.ProductBrandRepository;
import com.clockworkcode.pentagonbusinesscomv2.repository.ProductCategoryRepository;
import com.clockworkcode.pentagonbusinesscomv2.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductDBService {

    private final ProductRepository productRepository;
    private final ProductBrandRepository productBrandRepository;
    private final ProductCategoryRepository productCategoryRepository;


    @Autowired
    public ProductDBService(ProductRepository productRepository, ProductBrandRepository productBrandRepository, ProductCategoryRepository productCategoryRepository) {
        this.productRepository = productRepository;
        this.productBrandRepository = productBrandRepository;
        this.productCategoryRepository = productCategoryRepository;
    }

    public List<String> getAllProductBrands(){

        List<String> uniqueBrandNames = new ArrayList<>();

        productBrandRepository.findAll().forEach(productBrand -> uniqueBrandNames.add( productBrand.getProductBrandName() ) );

        return uniqueBrandNames.stream().distinct().collect(Collectors.toList());
    }

    public List<Product> getAllProducts(){return productRepository.findAll();}

    public List<Product> getProductsByName(String productName){
        return productRepository.getProductsByProductName(productName);
    }

    public List<Product> getProductsByProductCategoryName(String productCategoryName){
        ProductCategory productCategory = productCategoryRepository.getProductCategoryByProductCategoryName(productCategoryName);
        return productRepository.getProductsByProductCategory(productCategory);
    }

    public List<Product> getProductsByBrandName(String productBrandName){
        ProductBrand productBrand = productBrandRepository.getProductBrandByProductBrandName(productBrandName);
        return productRepository.getProductsByProductBrand(productBrand);
    }

    public List<Product> getProductsInStock(){
        return productRepository.getProductsByProductInventoryGreaterThan(0);
    }

    public List<Product> getProductsOutOfStock(){
        return productRepository.getProductsByProductInventoryEquals(0);
    }

    public Integer getAvailableQuantityByProductID(Long productID){
        return productRepository.getById(productID).getProductInventory();
    }


}
