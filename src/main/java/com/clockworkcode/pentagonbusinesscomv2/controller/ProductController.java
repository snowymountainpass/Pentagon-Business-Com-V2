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
@RequestMapping("e-shop/")
@CrossOrigin(origins = "http://localhost:3000/")
public class ProductController {

    @Autowired
    ProductDBService productDBService;
    
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

        List<Product> productsFromBrands = new ArrayList<>();


        brandsList
                .forEach(s -> productsFromBrands
                        .addAll(getAllProducts().stream()
                                .filter(product -> product.getProductBrand().getProductBrandName().equals(s))
                                .collect(Collectors.toList())));



        return productsFromBrands.size()!=0 ? ResponseEntity.ok().body(productsFromBrands) : ResponseEntity.ok().body(productDBService.getAllProducts());
    }

    @GetMapping("/get-min-max-price")
    public ResponseEntity<List<Integer>> getMinPrice(){

        List<Integer> minMaxValuesList = new ArrayList<>();

        minMaxValuesList.add(productDBService.getAllProducts().stream().min(Comparator.comparingInt(Product::getProductPrice)).get().getProductPrice());
        minMaxValuesList.add(productDBService.getAllProducts().stream().max(Comparator.comparingInt(Product::getProductPrice)).get().getProductPrice());



        return ResponseEntity.ok().body( minMaxValuesList.stream().distinct().collect(Collectors.toList()) );
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
        
        List<Product> products = new ArrayList<>();
        
        switch (deliveryTime){
            case "instock":{
                products=productDBService.getProductsInStock();
                break;
            }
            case "14days":{
                products=productDBService.getProductsOutOfStock();
                break;
            }
            case "all":{
                products=productDBService.getAllProducts();
                break;
            }
        }
        return ResponseEntity.ok().body(products);
    }

    @GetMapping("/get-product-by-id/{productID}")
    public ResponseEntity<Product> getProductById(@PathVariable String productID){
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
