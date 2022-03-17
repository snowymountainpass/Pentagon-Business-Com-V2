package com.clockworkcode.pentagonbusinesscomv2.service;

//import com.clockworkcode.pentagonbusinesscomv2.model.ProductCategoryLocal;
import com.clockworkcode.pentagonbusinesscomv2.model.product.Product;
import com.clockworkcode.pentagonbusinesscomv2.model.product.ProductBrand;
import com.clockworkcode.pentagonbusinesscomv2.model.product.ProductCategory;
import com.clockworkcode.pentagonbusinesscomv2.model.product.ProductInventory;
import com.clockworkcode.pentagonbusinesscomv2.repository.ProductBrandRepository;
import com.clockworkcode.pentagonbusinesscomv2.repository.ProductCategoryRepository;
import com.clockworkcode.pentagonbusinesscomv2.repository.ProductInventoryRepository;
import com.clockworkcode.pentagonbusinesscomv2.repository.ProductRepository;
//import com.clockworkcode.pentagonbusinesscomv2.service.DAO.ProductMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Configuration
public class ProductConfig {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductCategoryRepository productCategoryRepository;
    @Autowired
    ProductBrandRepository productBrandRepository;
    @Autowired
    ProductInventoryRepository productInventoryRepository;

    @Bean
    CommandLineRunner commandLineRunner(ProductRepository productRepository,ProductCategoryRepository productCategoryRepository,ProductBrandRepository productBrandRepository,ProductInventoryRepository productInventoryRepository) {
        return args -> {

            ProductCategory productCategory1 = new ProductCategory("TELEFON_SIP","telefoane SIP");
            ProductCategory productCategory2 = new ProductCategory("SISTEM_AUDIO_CONFERINTA","sisteme audio de conferinta");
            ProductCategory productCategory3 = new ProductCategory("CASTI_CALLCENTER","casti pentru uz in callcenter");
            ProductCategory productCategory4 = new ProductCategory("SWITCH","switch");
            ProductCategory productCategory5 = new ProductCategory("ACCESS_POINT_WIRELESS","access point-uri wireless");
            ProductCategory productCategory6 = new ProductCategory("SISTEM_VIDEO_CONFERINTA","sisteme video pentru conferinta");

//            productCategoryRepository.saveAll(Arrays.asList(productCategory1,productCategory2,productCategory3,productCategory4,productCategory5,productCategory6));


            ProductBrand productBrand1 = new ProductBrand("Alcatel-Lucent","https://www.al-enterprise.com/");
            ProductBrand productBrand2 = new ProductBrand("Konftel","https://www.konftel.com/");

//            productBrandRepository.saveAll(Arrays.asList(productBrand1,productBrand2));

            ProductInventory productInventory1 = new ProductInventory(10);
            ProductInventory productInventory2 = new ProductInventory(20);
            ProductInventory productInventory3 = new ProductInventory(50);
            ProductInventory productInventory4 = new ProductInventory(70);
            ProductInventory productInventory5 = new ProductInventory(100);
            ProductInventory productInventory6 = new ProductInventory(0);

//            productInventoryRepository.saveAll(Arrays.asList(productInventory1,productInventory2,productInventory3,productInventory4,productInventory5,productInventory6));

            Product product1 = new Product("ALCATEL H2",
                    "Model Number:H2;Type:VoIP Phone;Brand Name: Alcatel Lucent",
                    "12345",
                    productBrand1,
                    productCategory1,
                    productInventory1,
                    150,
                    8,
                    "../../Assets/img/Pentagon Assets/Product Images/ALCATEL-H2.png"
                    );


            Product product2 = new Product("ALCATEL M5",
                    "Mid-level enterprise-grade IP deskphone with 2.8” color display;Type:VoIP Phone;Brand Name: Alcatel Lucent",
                    "23456",
                    productBrand1,
                    productCategory1,
                    productInventory2,
                    200,
                    9,
                    "../../Assets/img/Pentagon Assets/Product Images/ALCATEL-M5.png"
            );

            Product product3 = new Product("EGO PERSONAL MODULE",
                    "Contents:Konftel Ego, USB cable (900103388),soft case and Quick guide.;Size: 145x135 mm, height 32 mm.;Weight:230 g.;Color:Licorice black.;Display: Color LCD, 128x160 pixels, 1.77”.;Keypad: Touchscreen buttons, call, end call, volume up, volume down, mute, Bluetooth®.;Battery:1000 mAh Li-ion, up to 12 hours of call time, 60 hours standby.;AC adapter:Power and charging via USB.USB: 2.0 Micro B.Bluetooth®:Bluetooth 4.0 (HFP, HSP, AVRCP,A2DP).",
                    "34567",
                    productBrand2,
                    productCategory2,
                    productInventory2,
                    500,
                    8,
                    "../../Assets/img/Pentagon Assets/Product Images/Konftel-EGO-PERSONAL-MODULE.png"
            );

            Product product4 = new Product("Konftel 800 SIP (USB)",
                    "Contents: Konftel 800, Ethernet cable 6.5 m (900103402), USB cable 1.5 m, quick guide, important notice document.;Size: 326 x 370 x 75 mm (WxLxH);Color: Black;Display: 4.3” 480x800 touch screen;Keypad: Two volume touch buttons, three mute touch buttons;During calls: Conference/split/hold/private, call waiting, calling line identifier (CLID).;Multi-party calls: Local five-way conferencing;USB: 1 x USB 3.0 host Type A, 1 x USB 3.0 device Micro-B;Expansion: 2 x audio expansion ports (RJ11);Bluetooth: Bluetooth® Audio (HFP/HSP/A2DP) with NFC.",
                    "45678",
                    productBrand2,
                    productCategory2,
                    productInventory3,
                    320,
                    8,
                    "../../Assets/img/Pentagon Assets/Product Images/Konftel-800-SIP-USB.png"
            );



            Product product5 = new Product("ALCATEL AH 22 U II  BINAURAL USB-A",
                    "Crystal-clear voice: refined speakers deliver richer intonation.;Noise-cancelling: the microphone minimizes background noise,intensifies your voice for enhanced call quality.;Durability: product durability is strengthened by the metal parts on both sides of the headsets.;Comfort: leatherette ear cushions, headbeams and adjustable headband are fit for long-time wearing.;3.5mm connector, USB A connector, and USB A to C converter, providing diverse connections to softphones on personal computers, deskphones, mobile phones and tablets.",
                    "56789",
                    productBrand1,
                    productCategory3,
                    productInventory4,
                    90,
                    9,
                    "../../Assets/img/Pentagon Assets/Product Images/ALCATEL-AH-22-U-II.png"
            );


            Product product6 = new Product("Switch 2260 8RJ45+4 SFP",
                    "8 Gigabit RJ45 ports;4 Gigabit SFP uplink ports;1 Console port;1 USB/OoB management port;Switch capacity with all ports (full duplex): 24Gb/s;Max switching ASIC capacity: 128Gb/s;Fanless operation;CPU: 800MHz MIPS-34Kc;File system flash: 512MB;RAM: 512MB;Packet Buffers: 12Mb/s;Switch frame rate @ 64 byte packet: 17.9Mpps;Fixed 1RU 1/2 rack chassis;Rack mounting with the optionally available Alcatel Lucent OS2260-RM-19-L - 19\" Rack Mount Kit for the OS2260-10/P10 switch;Wall mounting with the optionally available Alcatel Lucent OS2260-WALL-MNT - Wall Mounting Kit for the OS2260-10/P10 switch;Limited Lifetime warranty",
                    "67890",
                    productBrand1,
                    productCategory4,
                    productInventory5,
                    600,
                    9,
                    "../../Assets/img/Pentagon Assets/Product Images/Switch-2260-8RJ45+4-SFP.png"
            );




            Product product7 = new Product("Switch PoE 2260 24RJ45+4 SFP",
                    "8 Gigabit RJ45 ports;4 Gigabit SFP uplink ports;1 Console port;1 USB/OoB management port;Switch capacity with all ports (full duplex): 24Gb/s;Max switching ASIC capacity: 128Gb/s;Fanless operation;CPU: 800MHz MIPS-34Kc;File system flash: 512MB;RAM: 512MB;Packet Buffers: 12Mb/s;Switch frame rate @ 64 byte packet: 17.9Mpps;Fixed 1RU 1/2 rack chassis;Rack mounting with the optionally available Alcatel Lucent OS2260-RM-19-L - 19\" Rack Mount Kit for the OS2260-10/P10 switch;Wall mounting with the optionally available Alcatel Lucent OS2260-WALL-MNT - Wall Mounting Kit for the OS2260-10/P10 switch;Limited Lifetime warranty",
                    "67890",
                    productBrand1,
                    productCategory4,
                    productInventory6,
                    650,
                    8,
                    "../../Assets/img/Pentagon Assets/Product Images/Switch-PoE-2260-24RJ45+4-SFP.png"
            );


            // 8 & 9 - ACCESS POINT WIRELESS
            Product product8 = new Product(
                    "OAW-AP1201-RW",
                    "AP type: Indoor, dual radio, 5 GHz 802.11ac 2x2:2 MU-MIMO and 2.4 GHz 802.11n 2x2:2 MIMO;5 GHz: Two spatial stream single user (SU) /multi user (MU) MIMO for up to 867 Mb/s wireless data rate;Support up to 8 SSID per radio. Total 16 SSIDs (HW ready to extend to 32 SSID);Support for up to 512 associated client devices per AP;Up to 4K APs when managed by OV2500. There is no limit on the number of AP groups; Supports direct DC power and Power over Ethernet (PoE)",
                    "78901",
                    productBrand1,
                    productCategory5,
                    productInventory3,
                    200,
                    9,
                    "../../Assets/img/Pentagon Assets/Product Images/OAW-AP1201-RW.png"

            );

            Product product9 = new Product(
                    "OAW-AP1221-RW",
                    "AP type: Indoor, dual radio, 5 GHz 802.11ac 4x4:4 MU-MIMO and 2.4 GHz 802.11n 2x2:2 MIMO;5 GHz: Four spatial stream single user (SU) MIMO for up to 1733 Mb/s wireless data rate to individual 4x4 VHT80 or 2x2 VHT160* client devices;1x 10/100/1000Base-T autosensing (RJ-45) port, Power over Ethernet (PoE);1x USB 2.0 (Type A connector);1x management console port (RJ-45);Reset button: Factory reset;Kensington security slot;AP1222: 4x RP-SMA antenna connectors",
                    "89012",
                    productBrand1,
                    productCategory5,
                    productInventory4,
                    350,
                    9,
                    "../../Assets/img/Pentagon Assets/Product Images/OAW-AP1221-RW.png"
            );

            Product product10 = new Product(
                    "OAW-AP1321-RW",
                    "AP type: Indoor, integrated four radios;Dual Radio, 5 GHz 802.11ax 4x4:4 and 2.4 GHz 802.11ax 2x2:2;Advanced Cellular Coexistence (ACC);Full band 1x1 radio, dedicated for scanning;Bluetooth Low Energy (BLE) 5.1/ Zigbee radio, integrated antenna;1x 10BASE-Te/100BASE-TX/1000BASE-T/2500BASE-T IEEE 802.3 compliant autosensing (RJ-45) port, ENET0, Power over Ethernet (PoE) 802.3at compliant; 1x 10/100/1000 BASE-T IEEE 802.3 compliant auto-sensing (RJ-45) port, ENET1, Power over Ethernet (PoE) 802.3at compliant;1x USB 2.0 Type A (5V, 500mA);802.11i, WPA2, WPA3, Enterprise with CNSA Option, Personal (SAE), Enhanced Open (OWE);802.1X;WEP, Advanced Encryption Standard (AES), Temporal Key Integrity Protocol (TKIP);Firewall: ACL, wIPS/wIDS and DPI application policy enforcement with OmniVista;Portal page authentication;AP1321: 2×2:2 @ 2.4GHz, 4x4:4 @ 5GHz;AP1322: 2×2:2 @ 2.4GHz, 4x4:4 @ 5GHz;• MTBF: 1,104,490h (126.08 years) at +25ºC operating temperature",
                    "90123",
                    productBrand1,
                    productCategory5,
                    productInventory3,
                    400,
                    9,
                    "../../Assets/img/Pentagon Assets/Product Images/OAW-AP1321-RW.png"
            );

            //SISTEME DE VIDEO CONFERINTA - KONFTEL
            Product product11 = new Product(
                    "KONFTEL Huddle Room (CAM20 + EGO)",
                    "Video conference system composed of CAM20 video conference camera and EGO PERSONAL MODULE",
                    "01234",
                    productBrand2,
                    productCategory6,
                    productInventory2,
                    700,
                    9,
                    "../../Assets/img/Pentagon Assets/Product Images/Huddle Room (CAM20 + EGO).png"

            );



            Product product12 = new Product(
                    "KONFTEL Speakerphone personal kit (CAM10 + EGO)",
                    "Video conference system composed of CAM10 video conference camera and EGO PERSONAL MODULE",
                    "01234",
                    productBrand2,
                    productCategory6,
                    productInventory2,
                    650,
                    8,
                    "../../Assets/img/Pentagon Assets/Product Images/Speakerphone personal kit (CAM10 + EGO).png"


            );

            productCategoryRepository.saveAll(Arrays.asList(productCategory1,productCategory2,productCategory3,productCategory4,productCategory5,productCategory6));

            productCategory1.addProducts(Stream.of(product1,product2).collect(Collectors.toSet()));
            productCategory2.addProducts(Stream.of(product3,product4).collect(Collectors.toSet()));
            productCategory3.addProducts(Stream.of(product5).collect(Collectors.toSet()));
            productCategory4.addProducts(Stream.of(product6,product7).collect(Collectors.toSet()));
            productCategory5.addProducts(Stream.of(product8,product9,product10).collect(Collectors.toSet()));
            productCategory6.addProducts(Stream.of(product11,product12).collect(Collectors.toSet()));

            productBrandRepository.saveAll(Arrays.asList(productBrand1,productBrand2));

            productBrand1.addProducts(Stream.of(product1,product2,product5,product6,product7,product8,product9,product10).collect(Collectors.toSet()));
            productBrand2.addProducts(Stream.of(product3,product4,product11,product12).collect(Collectors.toSet()));

            productRepository.saveAll(Arrays.asList(product1,product2,product5,product6,product7,product3,product4,product8,product9,product10,product11,product12));

        };
    }
}
