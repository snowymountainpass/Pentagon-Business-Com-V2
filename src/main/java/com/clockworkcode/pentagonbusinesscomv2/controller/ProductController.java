package com.clockworkcode.pentagonbusinesscomv2.controller;

import com.clockworkcode.pentagonbusinesscomv2.model.product.Product;
import com.clockworkcode.pentagonbusinesscomv2.service.ProductDBService;
//import com.clockworkcode.pentagonbusinesscomv2.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/e-shop")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {

    @Autowired
    ProductDBService productDBService;

    @GetMapping()
    public List<Product> getAllProducts() {

//        productService.getAllProducts().forEach(product -> System.out.println(product.getProductName()));



        return productDBService.getAllProducts();
    }

    @GetMapping("/product/{productName}")
    public ResponseEntity<List<Product>> getProductsByName(@PathVariable String productName) {

//        System.out.println("productName: " + productName);
//        System.out.println("No. of products with this name: "+productService.getProductsByName(productName).size());
//        productService.getProductsByName(productName.toLowerCase()).forEach(product1 -> System.out.println(product1.getProductName()));

//        List<Product> listOfProducts = productService.getProductsByName(productName.toLowerCase());
        System.out.println("Product search value: " + productName);
//        List<Product> listOfProducts = productDBService.getProductsByName(productName.toLowerCase());
        List<Product> listOfProducts = productDBService.getAllProducts()
                .stream()
                .filter(product -> product.getProductName().toLowerCase().contains( productName.toLowerCase() ) ||
                        product.getProductBrand().getProductBrandName().toLowerCase().contains( productName.toLowerCase() ) ||
                        product.getProductCategory().getProductCategoryName().toLowerCase().contains( productName.toLowerCase() )
                )
                .collect(Collectors.toList());



        return ResponseEntity.ok().body(listOfProducts);

    }

    @GetMapping("/{productCategory}")
    public ResponseEntity<List<Product>>getProductsByCategory(@PathVariable String productCategory) {

//        System.out.println("SELECTED Product Category: "+ productCategory);

//        return ResponseEntity.ok().body( productDBService.getAllProductsByCategory(productCategory) );
        return ResponseEntity.ok().body( productDBService.getProductsByProductCategoryName(productCategory) );

    }

    @GetMapping("/unique-brands")
    public ResponseEntity<List<String>> getAllBrands(){

        return ResponseEntity.ok().body( productDBService.getAllProductBrands());
    }

    @PostMapping("/brands")
    public ResponseEntity<List<Product>> getProductsByBrands(@RequestBody List<String> brandsList){

        List<Product> productsFromBrands = new ArrayList<>();


        brandsList
                .forEach(s -> productsFromBrands
                        .addAll(getAllProducts().stream()
                                .filter(product -> product.getProductBrand().getProductBrandName().equals(s))
                                .collect(Collectors.toList())));



        return productsFromBrands.size()!=0 ? ResponseEntity.ok().body(productsFromBrands) : ResponseEntity.ok().body(productDBService.getAllProducts());
    }
//
//    @GetMapping("/min-price-only")
//    public  ResponseEntity<List<Product>> getProductsAboveMinPrice(@RequestParam Integer minPrice){
//
//        return ResponseEntity.ok().body( productService.getAllProducts().stream().filter(product -> product.getPrice()>=minPrice).collect(Collectors.toList()) );
//    }
//
//    @GetMapping("/min-max-prices")
//    public  ResponseEntity<List<Product>> getProductsAboveMinPrice(@RequestParam Integer minPrice,@RequestParam Integer maxPrice) {
//
//        return ResponseEntity.ok().body( productService.getAllProducts().stream().filter(product -> product.getPrice()>=minPrice && product.getPrice()<=maxPrice).collect(Collectors.toList()) );
//    }
//
//
//    @GetMapping("/price-descending")
//    public List<Product> getProductsPriceDecreasing() {
//
//        return productService.getProductsPriceDecreasing();
//    }
//
//    @GetMapping("/price-ascending")
//    public List<Product> getProductsPriceIncreasing() {
//        return productService.getProductsPriceIncreasing();
//    }

}
