package com.clockworkcode.pentagonbusinesscomv2.controller;

import com.clockworkcode.pentagonbusinesscomv2.model.product.Product;
import com.clockworkcode.pentagonbusinesscomv2.service.ProductDBService;
//import com.clockworkcode.pentagonbusinesscomv2.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("e-shop/")
@CrossOrigin(origins = "http://localhost:3000/")
public class ProductController {

    @Autowired
    ProductDBService productDBService;

    List<Integer> minMaxValuesList = new ArrayList<>();

    @GetMapping()
    public List<Product> getAllProducts() {

        return productDBService.getAllProducts();
    }

    @GetMapping("product/{productName}")
    public ResponseEntity<List<Product>> getProductsByName(@PathVariable(name = "productName") String productName) {


        System.out.println("Product search value: " + productName);
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

    @GetMapping("/get-min-max-price")
    public  ResponseEntity<List<Integer>> getMinPrice(){

//        List<Integer> minMaxValuesList = new ArrayList<>();

        minMaxValuesList.add(productDBService.getAllProducts().stream().min(Comparator.comparingInt(Product::getProductPrice)).get().getProductPrice());
        minMaxValuesList.add(productDBService.getAllProducts().stream().max(Comparator.comparingInt(Product::getProductPrice)).get().getProductPrice());



        return ResponseEntity.ok().body( minMaxValuesList.stream().distinct().collect(Collectors.toList()) );
    }


    @GetMapping("/min-price/{minPrice}")
    public  ResponseEntity<List<Product>> getProductsAboveMinPrice(@PathVariable(name = "minPrice") Integer minPrice){

        System.out.println("Current minPrice: "+minPrice);

        return ResponseEntity.ok().body( productDBService.getAllProducts().stream().filter(product -> product.getProductPrice()>=minPrice).collect(Collectors.toList()) );
    }

    @GetMapping("/max-price/{maxPrice}")
    public  ResponseEntity<List<Product>> getProductsBelowMaxPrice(@PathVariable(name = "maxPrice") Integer maxPrice){

        System.out.println("Current maxPrice: "+maxPrice);

        return ResponseEntity.ok().body( productDBService.getAllProducts().stream().filter(product -> product.getProductPrice()<=maxPrice).collect(Collectors.toList()) );
    }

//    @GetMapping("/min-max-prices")
//    public  ResponseEntity<List<Product>> getProductsInInterval(@RequestBody List<Integer> minMaxPrices) {
//
//        return ResponseEntity.ok().body( productDBService.getAllProducts().stream().filter(product -> product.getProductPrice()>=minMaxPrices.get(0) && product.getProductPrice()<=minMaxPrices.get(1)).collect(Collectors.toList()) );
//    }

    @GetMapping("/min-max-prices/{minVal}-{maxVal}")
    public  ResponseEntity<List<Product>> getProductsInInterval(@PathVariable String minVal,@PathVariable String maxVal) {

        System.out.println("minval:"+minVal);
        System.out.println("maxval:"+maxVal);

        Integer minPrice = minMaxValuesList.get(0);
        Integer maxPrice = minMaxValuesList.get(1);

        return ResponseEntity.ok().body( productDBService.getAllProducts().stream().filter(product -> product.getProductPrice()>=minPrice && product.getProductPrice()<=maxPrice).collect(Collectors.toList()) );
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
