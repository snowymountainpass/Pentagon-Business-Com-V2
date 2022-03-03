package com.clockworkcode.pentagonbusinesscomv2.controller;

import com.clockworkcode.pentagonbusinesscomv2.model.Product;
import com.clockworkcode.pentagonbusinesscomv2.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/e-shop")
@CrossOrigin(origins ="http://localhost:3000")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping()
    public List<Product> getAllProducts(){

//        productService.getAllProducts().forEach(product -> System.out.println(product.getProductName()));

        return productService.getAllProducts();
    }

    @GetMapping("/{productCategory}")
    public List<Product> getProductsByCategory(@PathVariable String productCategory){

       return productService.getAllProductsByCategory(productCategory);

    }

    @GetMapping("/product/")
    public List<Product> getProductsByName(@RequestBody Product product){

        System.out.println("No. of products with this name: "+productService.getProductsByName(product.getProductName().toLowerCase()).size());

        productService.getProductsByName(product.getProductName().toLowerCase()).forEach(product1 -> System.out.println(product1.getProductName()));

        return productService.getProductsByName(product.getProductName().toLowerCase());

    }

    @GetMapping("/price-descending")
    public List<Product> getProductsPriceDecreasing(){

        return productService.getProductsPriceDecreasing();
    }

    @GetMapping("/price-ascending")
    public List<Product> getProductsPriceIncreasing(){
        return productService.getProductsPriceIncreasing();
    }

}
