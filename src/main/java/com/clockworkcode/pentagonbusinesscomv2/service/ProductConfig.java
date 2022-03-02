package com.clockworkcode.pentagonbusinesscomv2.service;

import com.clockworkcode.pentagonbusinesscomv2.model.Product;
import com.clockworkcode.pentagonbusinesscomv2.model.ProductCategory;
import com.clockworkcode.pentagonbusinesscomv2.service.DAO.ProductMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;

@Configuration
public class ProductConfig {

    @Autowired
    ProductMemory productMemory;

    @Bean
    CommandLineRunner commandLineRunner(ProductMemory productMemory){
        return args -> {

            Product product1 = new Product(1,"ALCATEL H2", ProductCategory.TELEFON_SIP,"Model Number:H2\n" + "Type:VoIP Phone"+"Brand Name: Alcatel Lucent Network:Wireless Lan, Wired LAN, wifi\n" +"Connectivity:RJ-45 LAN: 10/100M Ethernet switch",10,150,"https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.al-enterprise.com%2F-%2Fmedia%2Fassets%2Finternet%2Fdocuments%2Fh2-h2p-deskphone-datasheet-en.pdf&psig=AOvVaw1-j0agE-KhbmwklCAFRzSc&ust=1646339050113000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCJDysYahqPYCFQAAAAAdAAAAABAe",8);
            Product product2 = new Product(2,"ALCATEL M5", ProductCategory.TELEFON_SIP, "Mid-level enterprise-grade IP deskphone with 2.8” color display. The M5 offers richer visual experiences to users. It is built with advanced super wideband audio for immersive voice communication experiences. In addition to enhanced telephony features, the phone is also integrated with customizable faceplate for brand advocate.",10,200,"frontend/src/Assets/img/Pentagon Assets/Product Images/ALCATEL M5.png",9);
//            Product product3 = new Product();
//            Product product4 = new Product();
//            Product product5 = new Product();
//            Product product6 = new Product();
//            Product product7 = new Product();
//            Product product8 = new Product();
//            Product product9 = new Product();
//            Product product10 = new Product();
//            Product product11 = new Product();
//            Product product12 = new Product();

            Collections.addAll(productMemory.getAllProducts(),product1,product2);

//            productMemory.getAllProducts().forEach(product -> System.out.println(product.getProductName()));

        };
    }
}
