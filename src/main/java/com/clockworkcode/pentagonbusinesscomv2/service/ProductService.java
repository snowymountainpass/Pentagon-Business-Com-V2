//package com.clockworkcode.pentagonbusinesscomv2.service;
//
//import com.clockworkcode.pentagonbusinesscomv2.model.Product;
//import com.clockworkcode.pentagonbusinesscomv2.service.DAO.ProductDAO;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class ProductService {
//
//    @Autowired
//    private ProductDAO productDAO;
//
//
//    public List<Product> getAllProducts(){
//        return productDAO.getAllProducts();
//    }
//
//    public List<Product> getAllProductsByCategory(String productCategory){
//        return productDAO.getAllProductsByCategory(productCategory);
//    }
//
//    public List<Product> getProductsByName(String productName){
//        return productDAO.getProductsByName(productName);
//    }
//
//    public List<Product> getProductsPriceDecreasing(){
//        return productDAO.getProductsPriceDecreasing();
//    }
//
//    public List<Product> getProductsPriceIncreasing(){
//        return productDAO.getProductsPriceIncreasing();
//    }
//
//}
