package com.clockworkcode.pentagonbusinesscomv2.controller;


import com.clockworkcode.pentagonbusinesscomv2.model.product.Product;
import com.clockworkcode.pentagonbusinesscomv2.model.shopping.CartItem;
import com.clockworkcode.pentagonbusinesscomv2.service.ShoppingSessionService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Hashtable;
import java.util.List;

@RestController
@RequestMapping(path = "/e-shop")
@CrossOrigin(origins = "http://localhost:3000")
@AllArgsConstructor
@Getter
@Setter
@Slf4j
public class ShoppingSessionController {
    private final ShoppingSessionService shoppingSessionService;


    @PostMapping("/login/{userToken}")
    public void getLoggedInUserToken(@PathVariable String userToken){

        log.info("REACHED ROUTE /login/{userToken}: "+ userToken);

        shoppingSessionService.addNewShoppingSession(userToken);

    }

    @GetMapping("/shopping-cart/{loginToken}")
    public ResponseEntity<Hashtable<Long,List<String>>> getProductsAndQuantitiesInCart(@PathVariable String loginToken){

        log.info("ShoppingSessionController -> reached /shopping-cart/"+loginToken);

        Hashtable<Long,List<String>> productsInCart = shoppingSessionService.getListProductsAndQuantities(loginToken);

        return ResponseEntity.ok().body( shoppingSessionService.getListProductsAndQuantities(loginToken) );
    }
}
