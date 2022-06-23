package com.clockworkcode.pentagonbusinesscomv2.service;

import com.clockworkcode.pentagonbusinesscomv2.model.product.Product;
import com.clockworkcode.pentagonbusinesscomv2.model.product.ProductCategory;
import com.clockworkcode.pentagonbusinesscomv2.repository.ProductBrandRepository;
import com.clockworkcode.pentagonbusinesscomv2.repository.ProductCategoryRepository;
import com.clockworkcode.pentagonbusinesscomv2.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ProductDBService {

    private final ProductRepository productRepository;
    private final ProductBrandRepository productBrandRepository;
    private final ProductCategoryRepository productCategoryRepository;


    @Autowired
    public ProductDBService(ProductRepository productRepository, ProductBrandRepository productBrandRepository, ProductCategoryRepository productCategoryRepository) {
        this.productRepository = productRepository;
        this.productBrandRepository = productBrandRepository;
        this.productCategoryRepository = productCategoryRepository;
    }

    public List<Product> getAllProducts(){return productRepository.findAll();}


    public List<String> getAllProductCategories(){
        List<String> uniqueProductCategoryNames = new ArrayList<>();

        productRepository.findAll().forEach(product -> uniqueProductCategoryNames.add(product.getProductCategory().getProductCategoryName() ));

        return uniqueProductCategoryNames.stream().distinct().collect(Collectors.toList());
    }

    public List<String> getAllProductBrands(){

        List<String> uniqueBrandNames = new ArrayList<>();

        productBrandRepository.findAll().forEach(productBrand -> uniqueBrandNames.add( productBrand.getProductBrandName() ) );

        return uniqueBrandNames.stream().distinct().collect(Collectors.toList());
    }

    public List<Product> getProductsByName(String productName){
        return getAllProducts()
                .stream()
                .filter(product -> product.getProductName().toLowerCase().contains( productName.toLowerCase() ) ||
                        product.getProductBrand().getProductBrandName().toLowerCase().contains( productName.toLowerCase() ) ||
                        product.getProductCategory().getProductCategoryName().toLowerCase().contains( productName.toLowerCase() )
                )
                .collect(Collectors.toList());
    }

    public Product getProductByProductID(String productID){
        return productRepository.getProductByProductID(Long.valueOf(productID));
    }

    public List<Product> getProductsByProductCategoryName(String productCategoryName){
        ProductCategory productCategory = productCategoryRepository.getProductCategoryByProductCategoryName(productCategoryName);
        return productRepository.getProductsByProductCategory(productCategory);
    }

    public List<Product> getProductsByBrandNames(List<String> productBrandNames){

        List<Product> productsFromBrands = new ArrayList<>();


        productBrandNames
                .forEach(s -> productsFromBrands
                        .addAll(getAllProducts().stream()
                                .filter(product -> product.getProductBrand().getProductBrandName().equals(s))
                                .collect(Collectors.toList())));

        return productsFromBrands.size()!=0 ? productsFromBrands : getAllProducts();
    }

    public List<Integer> getMinMaxPrices(){
        List<Integer> minMaxValuesList = new ArrayList<>();

        minMaxValuesList.add(getAllProducts().stream().min(Comparator.comparingInt(Product::getProductPrice)).get().getProductPrice());
        minMaxValuesList.add(getAllProducts().stream().max(Comparator.comparingInt(Product::getProductPrice)).get().getProductPrice());

        return minMaxValuesList.stream().distinct().collect(Collectors.toList());
    }

    public List<Product> getProductsInInterval(String minVal,String maxVal){

        Integer minPrice;
        Integer maxPrice;

        if(Objects.equals(minVal, "") && Objects.equals(maxVal, "")){
            minPrice = getMinMaxPrices().get(0);
            maxPrice = getMinMaxPrices().get(1);
        }
        else if( Objects.equals(minVal, "") && !Objects.equals(maxVal, "") ){
            minPrice = getMinMaxPrices().get(0);
            maxPrice = Integer.parseInt(maxVal);
        }
        else if( !Objects.equals(minVal, "") && Objects.equals(maxVal, "") ){
            minPrice = Integer.parseInt(minVal);
            maxPrice = getMinMaxPrices().get(1);
        }
        else {
            minPrice = Integer.parseInt(minVal);
            maxPrice = Integer.parseInt(maxVal);
        }

        return  getAllProducts().stream().filter(product -> product.getProductPrice()>=minPrice && product.getProductPrice()<=maxPrice).collect(Collectors.toList());
    }

    public List<Product> getProductsInStock(){
        return productRepository.getProductsByProductInventoryGreaterThan(0);
    }

    public List<Product> getProductsOutOfStock(){
        return productRepository.getProductsByProductInventoryEquals(0);
    }

    public List<Product> getProductsByDeliveryTime(String deliveryTime){

        List<Product> products = new ArrayList<>();

        switch (deliveryTime){
            case "instock":{
                products=getProductsInStock();
                break;
            }
            case "14days":{
                products=getProductsOutOfStock();
                break;
            }
            case "all":{
                products=getAllProducts();
                break;
            }
        }
        return products;

    }

     //TODO - UNIFY FILTERS

}
