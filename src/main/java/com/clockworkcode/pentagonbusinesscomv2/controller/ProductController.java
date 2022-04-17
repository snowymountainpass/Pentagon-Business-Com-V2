package com.clockworkcode.pentagonbusinesscomv2.controller;

import com.clockworkcode.pentagonbusinesscomv2.model.product.Product;
import com.clockworkcode.pentagonbusinesscomv2.service.ProductDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("e-shop")
@CrossOrigin(origins = "http://localhost:3000/")
public class ProductController {

    @Autowired
    ProductDBService productDBService;
    
    @GetMapping()
    public List<Product> getAllProducts() {

        List<Product> allProducts = productDBService.getAllProducts();

        return productDBService.getAllProducts();
    }

    @GetMapping("/product/{productName}")
    public ResponseEntity<List<Product>> getProductsByName(@PathVariable(name = "productName") String productName) {

        return ResponseEntity.ok().body(productDBService.getProductsByName(productName));

    }

    @GetMapping("/unique-product-categories")
    public ResponseEntity<List<String>> getAllProductCategories(){
        return ResponseEntity.ok().body( productDBService.getAllProductCategories() );
    }

    @GetMapping("/{productCategory}")
    public ResponseEntity<List<Product>>getProductsByCategory(@PathVariable String productCategory) {

        List<Product> products;

        if(Objects.equals(productCategory, "ALL TYPES")){
            products = getAllProducts();
        }
        else {
            products = productDBService.getProductsByProductCategoryName(productCategory);
        }

        return ResponseEntity.ok().body( products );

    }

    @GetMapping("/unique-brands")
    public ResponseEntity<List<String>> getAllBrands(){

        return ResponseEntity.ok().body( productDBService.getAllProductBrands());
    }

    @PostMapping("/brands")
    public ResponseEntity<List<Product>> getProductsByBrands(@RequestBody List<String> brandsList){

        return ResponseEntity.ok().body(productDBService.getProductsByBrandNames(brandsList));
    }

    @GetMapping("/get-min-max-price")
    public ResponseEntity<List<Integer>> getMinPrice(){


        return ResponseEntity.ok().body( productDBService.getMinMaxPrices() );
    }
    
    @GetMapping("/min-max-prices/{minVal}-{maxVal}")
    public ResponseEntity<List<Product>> getProductsInInterval(@PathVariable String minVal,@PathVariable String maxVal) {
        Integer minPrice;
        Integer maxPrice;
        List<Integer> minMaxValuesList = new ArrayList<>();

        minMaxValuesList.add(productDBService.getAllProducts().stream().min(Comparator.comparingInt(Product::getProductPrice)).get().getProductPrice());
        minMaxValuesList.add(productDBService.getAllProducts().stream().max(Comparator.comparingInt(Product::getProductPrice)).get().getProductPrice());

        
        if(Objects.equals(minVal, "") && Objects.equals(maxVal, "")){
             minPrice = minMaxValuesList.get(0);
             maxPrice = minMaxValuesList.get(1);
        }
        else if( Objects.equals(minVal, "") && !Objects.equals(maxVal, "") ){
            minPrice = minMaxValuesList.get(0);
            maxPrice = Integer.parseInt(maxVal);
        }
        else if( !Objects.equals(minVal, "") && Objects.equals(maxVal, "") ){
            minPrice = Integer.parseInt(minVal);
            maxPrice = minMaxValuesList.get(1);
        }
        else {
             minPrice = Integer.parseInt(minVal);
             maxPrice = Integer.parseInt(maxVal);
        }

//        System.out.println("minPrice: "+minPrice+" - "+"maxPrice: "+maxPrice);

        return ResponseEntity.ok().body( productDBService.getAllProducts().stream().filter(product -> product.getProductPrice()>=minPrice && product.getProductPrice()<=maxPrice).collect(Collectors.toList()) );
    }
    
    @GetMapping("/delivery-time/{deliveryTime}")
    public ResponseEntity<List<Product>> getProductsByDeliveryTime(@PathVariable String deliveryTime){

        return ResponseEntity.ok().body( productDBService.getProductsByDeliveryTime(deliveryTime) );
    }

    @GetMapping("/product-get-by-id/{productID}")
    public ResponseEntity<Product> getProductById(@PathVariable String productID ){
        System.out.println("Product ID: "+productID);

        System.out.println("Product: "+ productDBService.getProductByProductID(productID));

        return ResponseEntity.ok().body( productDBService.getProductByProductID(productID));
    }

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
