package com.clockworkcode.pentagonbusinesscomv2.controller;


import com.clockworkcode.pentagonbusinesscomv2.service.ShoppingSessionService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

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


}
