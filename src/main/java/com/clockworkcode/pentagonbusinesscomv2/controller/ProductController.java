package com.clockworkcode.pentagonbusinesscomv2.controller;

import com.clockworkcode.pentagonbusinesscomv2.model.Product;
import com.clockworkcode.pentagonbusinesscomv2.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/e-shop")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping()
    public List<Product> getAllProducts() {

//        productService.getAllProducts().forEach(product -> System.out.println(product.getProductName()));

        return productService.getAllProducts();
    }

    @GetMapping("/{productCategory}")
    public List<Product> getProductsByCategory(@PathVariable String productCategory) {

        return productService.getAllProductsByCategory(productCategory);

    }

    @GetMapping("/product/{productName}")
    public ResponseEntity<List<Product>> getProductsByName(@PathVariable String productName) {

        System.out.println("productName: " + productName);

//        System.out.println("No. of products with this name: "+productService.getProductsByName(productName).size());

        List<Product> listOfProducts = productService.getProductsByName(productName.toLowerCase());
//               productService.getProductsByName(productName.toLowerCase()).forEach(product1 -> System.out.println(product1.getProductName()));

        return ResponseEntity.ok().body(listOfProducts);

    }

    @GetMapping("/price-descending")
    public List<Product> getProductsPriceDecreasing() {

        return productService.getProductsPriceDecreasing();
    }

    @GetMapping("/price-ascending")
    public List<Product> getProductsPriceIncreasing() {
        return productService.getProductsPriceIncreasing();
    }

}
