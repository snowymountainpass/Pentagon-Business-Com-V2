package com.clockworkcode.pentagonbusinesscomv2.service.DAO;

import com.clockworkcode.pentagonbusinesscomv2.model.Product;
import org.springframework.stereotype.Repository;

import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.stream.Collectors;

@Repository
public class ProductMemory implements ProductDAO {

    private List<Product> productList;

    public ProductMemory(List<Product> productList){this.productList=productList;}


    public void addProductToList(Product newProduct){
        productList.add(newProduct);
    }

    @Override
    public List<Product> getAllProducts() {
        return productList;
    }

    @Override
    public List<Product> getAllProductsByCategory(String productCategory) {
        return productList.stream().filter(product -> Objects.equals(product.getProductCategory().toString(), productCategory)).collect(Collectors.toList());
    }

    @Override
    public List<Product> getProductsByName(String productName) {

//        productList.forEach(product -> System.out.println(product.getProductName()));
//        System.out.println("No. of products: "+ productList.size());
//
//        productList.stream().filter(product -> product.getProductName().contains(productName)).collect(Collectors.toList()).forEach(product -> System.out.println(product.getProductName()));

        System.out.println("productName: "+productName);

//        String test = "alcatel h2";
//        boolean isFound = test.contains(productName); // true
//
//        System.out.println(isFound);

        return productList.stream().filter(product -> product.getProductName().toLowerCase().contains(productName)).collect(Collectors.toList());
    }

    @Override
    public List<Product> getProductsPriceDecreasing() {

        return productList.stream().sorted(Comparator.comparingInt(Product::getPrice).reversed()).collect(Collectors.toList());
    }

    @Override
    public List<Product> getProductsPriceIncreasing() {
        return productList.stream().sorted(Comparator.comparingInt(Product::getPrice)).collect(Collectors.toList());
    }
}
