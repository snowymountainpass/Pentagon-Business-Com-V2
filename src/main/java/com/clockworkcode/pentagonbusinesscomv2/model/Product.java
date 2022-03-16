package com.clockworkcode.pentagonbusinesscomv2.model;
import lombok.*;

@Getter
@Setter
@ToString
//@Data
@AllArgsConstructor
public class Product {

    int productID;
    String productName;
    ProductCategoryLocal productCategoryLocal;
    String productDescription;
    String brand;
    int quantity;
    int price;
    String img;
    int rating;
    float deliveryCost;

    public void setDeliveryCost() {
        this.deliveryCost = ((price*quantity)*15)/100;
    }
}
