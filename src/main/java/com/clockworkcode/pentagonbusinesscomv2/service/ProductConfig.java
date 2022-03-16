package com.clockworkcode.pentagonbusinesscomv2.service;

import com.clockworkcode.pentagonbusinesscomv2.model.Product;
import com.clockworkcode.pentagonbusinesscomv2.model.ProductCategoryLocal;
import com.clockworkcode.pentagonbusinesscomv2.model.product.ProductBrand;
import com.clockworkcode.pentagonbusinesscomv2.model.product.ProductCategory;
import com.clockworkcode.pentagonbusinesscomv2.repository.ProductBrandRepository;
import com.clockworkcode.pentagonbusinesscomv2.repository.ProductCategoryRepository;
import com.clockworkcode.pentagonbusinesscomv2.repository.ProductRepository;
import com.clockworkcode.pentagonbusinesscomv2.service.DAO.ProductMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Instant;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;

@Configuration
public class ProductConfig {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductCategoryRepository productCategoryRepository;
    @Autowired
    ProductBrandRepository productBrandRepository;


    @Bean
    CommandLineRunner commandLineRunner(ProductRepository productRepository,ProductCategoryRepository productCategoryRepository,ProductRepository ProductBrandRepository) {
        return args -> {

            ProductCategory productCategory1 = new ProductCategory("TELEFON_SIP","telefoane SIP");
            ProductCategory productCategory2 = new ProductCategory("SISTEM_AUDIO_CONFERINTA","sisteme audio de conferinta");
            ProductCategory productCategory3 = new ProductCategory("CASTI_CALLCENTER","casti pentru uz in callcenter");
            ProductCategory productCategory4 = new ProductCategory("SWITCH","switch");
            ProductCategory productCategory5 = new ProductCategory("ACCESS_POINT_WIRELESS","access point-uri wireless");
            ProductCategory productCategory6 = new ProductCategory("SISTEM_VIDEO_CONFERINTA","sisteme video pentru conferinta");

            productCategoryRepository.saveAll(Arrays.asList(productCategory1,productCategory2,productCategory3,productCategory4,productCategory5,productCategory6));


            ProductBrand productBrand1 = new ProductBrand("Alcatel-Lucent","https://www.al-enterprise.com/");
            ProductBrand productBrand2 = new ProductBrand("Konftel","https://www.konftel.com/");

            productBrandRepository.saveAll(Arrays.asList(productBrand1,productBrand2));


//            Product product1 = new Product()

//            Product product1 = new Product(1, "ALCATEL H2", ProductCategoryLocal.TELEFON_SIP, "● Model Number:H2\n" +
//                    "● Type:VoIP Phone\n" +
//                    "● Brand Name: Alcatel Lucent\n" +
//                    "● Network:Wireless Lan, Wired LAN, wifi\n" +
//                    "● Connectivity:RJ-45 LAN: 10/100M Ethernet switch\n" +
//                    "● Height: 205mm (8.1 inches)\n" +
//                    "● Width:181mm (7.1 inches)\n" +
//                    "● Depth:47mm (1.9 inches)\n" +
//                    "● Weight:700g (1.54 lbs) incl. handset and foot stand\n" +
//                    "● Color:Gray"
//                    , "Alcatel-Lucent", 10, 150, "../../Assets/img/Pentagon Assets/Product Images/ALCATEL-H2.png", 8, 0);
//
//            //https://drive.google.com/file/d/1PCjwRMzDuIQkXVBkwQ-VFnjHWvgAkEse/view?usp=sharing //../assets/images/Pentagon Assets/Product Images/ALCATEL-H2.png
//            Product product2 = new Product(2, "ALCATEL M5", ProductCategoryLocal.TELEFON_SIP,
//                    "● Mid-level enterprise-grade IP deskphone with 2.8” color display. " +
//                            "● The M5 offers richer visual experiences to users. " +
//                            "● It is built with advanced super wideband audio for immersive voice communication experiences. " +
//                            "● In addition to enhanced telephony features, the phone is also integrated with customizable faceplate for brand advocate.", "Alcatel-Lucent", 10, 200, "../../Assets/img/Pentagon Assets/Product Images/ALCATEL-M5.png",
//                    9, 0);
//
//            Product product3 = new Product(3, "EGO PERSONAL MODULE", ProductCategoryLocal.SISTEM_AUDIO_CONFERINTA,
//                    "Meeting size: Up to 6 people\n" +
//                            "-Bluetooth®\n" +
//                            "- Small and portable\n" +
//                            "- OmniSound® with HD audio\n" +
//                            "- LCD screen\n" +
//                            "- Supports Skype for Business,Cisco Jabber, Avaya Equinox and other meeting tools.\n" +
//                            "- Stream music in HD (A2DP)\n" +
//                            "- Wireless headset connection\n", "Konftel", 10, 500, "../../Assets/img/Pentagon Assets/Product Images/Konftel-EGO-PERSONAL-MODULE.png", 8, 0);
//
//
//            Product product4 = new Product(4, "Konftel 800 SIP (USB)", ProductCategoryLocal.SISTEM_AUDIO_CONFERINTA, " Specifications\n" +
//                    "Room type: Small to Large\n" +
//                    "SIP\n" +
//                    "USB\n" +
//                    "Bluetooth with HD\n" +
//                    "\n" +
//                    "NFC for easy pairing\n" +
//                    "Audio expansion ports\n" +
//                    "PoE (Power over Ethernet)\n" +
//                    "\n" +
//                    "OmniSound® with HD audio\n" +
//                    "\n" +
//                    "Effortless phone and meeting management via Konftel Unite\n" +
//                    "Daisy-chain for maximum coverage\n" +
//                    "Hybrid: combine meeting app and phone calls\n" +
//                    "Efficient, scalable provisioning\n" +
//                    "Two-year warranty\n" +
//                    "Easy to use touch interface\n" +
//                    "\n" +
//                    "Supports Konftel Smart Microphones\n" +
//                    "USB for PC-based collaboration\n" +
//                    "Built-in bridge for 5-way calls\n" +
//                    "Free software updates\n" +
//                    "Climate Neutral Certified", "Konftel", 10, 320, "../../Assets/img/Pentagon Assets/Product Images/Konftel-800-SIP-USB.png", 9, 0);
//
//
//            Product product5 = new Product(5, "ALCATEL AH 22 U II  BINAURAL USB-A", ProductCategoryLocal.CASTI_CALLCENTER, "The second-generation Alcatel-Lucent Enterprise Aries 20 Series\n" +
//                    "(Aries 20 Series II) headsets are now available, offering crisp audio,\n" +
//                    "sophisticated comfort and increased durability. The new models of\n" +
//                    "Aries 20 Series II headsets are suitable for call centers, financial\n" +
//                    "services, online education, and unified communications.\n" +
//                    "Crystal-clear voice: refined speakers deliver richer intonation.\n" +
//                    "Noise-cancelling: the microphone minimizes background noise, and\n" +
//                    "intensifies your voice for enhanced call quality.\n" +
//                    "Durability: product durability is strengthened by the metal parts\n" +
//                    "on both sides of the headsets.\n" +
//                    "Comfort: leatherette ear cushions, headbeams and adjustable\n" +
//                    "headband are fit for long-time wearing.\n" +
//                    "Multiple connection interfaces: new models have connection options available including\n" +
//                    "3.5mm connector, USB A connector, and USB A to C converter, providing diverse connections\n" +
//                    "to softphones on personal computers, deskphones, mobile phones and tablets.", "Alcatel-Lucent", 10, 20, "../../Assets/img/Pentagon Assets/Product Images/ALCATEL-AH-22-U-II.png", 8, 0);
//
//            Product product6 = new Product(
//                    6,
//                    "Switch 2260 8RJ45+4 SFP",
//                    ProductCategoryLocal.SWITCH,
//                    "Fixed 1RU ½ rack chassis 8 RJ 45 10/100/1G BaseT, 4 SFP (1G) uplink ports, Fan-less"
//                    , "Alcatel-Lucent",
//                    10, 600,
//                    "../../Assets/img/Pentagon Assets/Product Images/Switch-2260-8RJ45+4-SFP.png", 9, 0
//
//            );
//
//            Product product7 = new Product(
//                    7, "Switch PoE 2260 24RJ45+4 SFP", ProductCategoryLocal.SWITCH, " Fixed 1RU chassis 24 RJ 45 PoE 10/100/1G BaseT, 4 SFP (1G) uplink ports, 195W power budget", "Alcatel-Lucent", 10, 500,
//                    "../../Assets/img/Pentagon Assets/Product Images/Switch-PoE-2260-24RJ45+4-SFP.png", 8, 0
//
//            );


//            Product product8 = new Product();
//            Product product9 = new Product();
//            Product product10 = new Product();
//            Product product11 = new Product();
//            Product product12 = new Product();



//            Collections.addAll(productMemory.getAllProducts(), product1, product2, product3, product4, product5, product6, product7);

//            productMemory.getAllProducts().forEach(product -> System.out.println(product.getProductName()));

        };
    }
}
