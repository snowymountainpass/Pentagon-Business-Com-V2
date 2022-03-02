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
    ProductCategory productCategory;
    String productDescription;
    int quantity;
    int price;
    String img;

}
