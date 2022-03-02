package com.clockworkcode.pentagonbusinesscomv2.service.DAO;

import com.clockworkcode.pentagonbusinesscomv2.model.Product;
import org.springframework.stereotype.Repository;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Repository
public class ProductMemory implements ProductDAO {

    private List<Product> productList;

    public ProductMemory(List<Product> productList){this.productList=productList;}

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
        return productList.stream().filter(product -> product.getProductName().equals(productName)).collect(Collectors.toList());
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
