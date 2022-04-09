package com.clockworkcode.pentagonbusinesscomv2.controller;

import com.clockworkcode.pentagonbusinesscomv2.model.request.CartItemRequest;
import com.clockworkcode.pentagonbusinesscomv2.service.CartItemService;
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
public class CartItemController {

    private final CartItemService cartItemService;
    private final ShoppingSessionController shoppingSessionController;


    @PostMapping("/cart-items/add-product")
    public void addProductToCart(@RequestBody CartItemRequest request){

        System.out.println("Request - token: "+request.getUserToken());
        System.out.println("Request - productID: "+request.getProductID());
        System.out.println("Request - quantity: "+request.getQuantity());


        cartItemService.updateCartItemQuantity(
                request.getUserToken(),
                Long.valueOf(request.getProductID()),
                Integer.valueOf(request.getQuantity())


        );

    }


}
