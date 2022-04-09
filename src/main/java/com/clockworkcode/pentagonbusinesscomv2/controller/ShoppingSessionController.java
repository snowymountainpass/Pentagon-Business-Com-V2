package com.clockworkcode.pentagonbusinesscomv2.controller;


import com.clockworkcode.pentagonbusinesscomv2.service.ShoppingSessionService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/e-shop")
@CrossOrigin(origins = "http://localhost:3000")
@AllArgsConstructor
@Getter
@Setter
public class ShoppingSessionController {

    private final ShoppingSessionService shoppingSessionService;

    String userToken;

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    @PostMapping("/login/{userToken}")
    public void getLoggedInUserToken(@PathVariable String userToken){

        System.out.println("REACHED ROUTE /login/{userToken}: "+ userToken);

        shoppingSessionService.addNewShoppingSession(userToken);

        setUserToken(userToken);
    }


}
