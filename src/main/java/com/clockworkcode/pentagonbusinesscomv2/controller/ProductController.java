package com.clockworkcode.pentagonbusinesscomv2.controller;

import com.clockworkcode.pentagonbusinesscomv2.model.Product;
import com.clockworkcode.pentagonbusinesscomv2.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/e-shop/")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/e-shop/{productCategory}")
    public List<Product> getProductsByCategory(@PathVariable String productCategory){

       return productService.getAllProductsByCategory(productCategory);

    }

    @GetMapping("/e-shop")
    public List<Product> getProductsByName(@RequestBody String productName){

        return productService.getProductsByName(productName);

    }

    @GetMapping("/e-shop/price-descending")
    public List<Product> getProductsPriceDecreasing(){

        return productService.getProductsPriceDecreasing();
    }

    @GetMapping("/e-shop/price-ascending")
    public List<Product> getProductsPriceIncreasing(){
        return productService.getProductsPriceIncreasing();
    }

}
