package com.clockworkcode.pentagonbusinesscomv2.controller;

import com.clockworkcode.pentagonbusinesscomv2.model.request.CartItemRequest;
import com.clockworkcode.pentagonbusinesscomv2.service.CartItemService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping(path = "/e-shop")
@CrossOrigin(origins = "http://localhost:3000")
@AllArgsConstructor
@Getter
@Setter
@Slf4j
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

    @GetMapping("/cart-items/get-shopping-cart-total-number-of-items")
    public Integer getTotalNumberOfItemsInCart(){

        log.info("Number of items in cart: "+cartItemService.getNumberItemsInCart());

        return cartItemService.getNumberItemsInCart();
    }

    @GetMapping("/cart-items/{cartItemID}")
    public void removeCardItemByID(@PathVariable String cartItemID){
        log.info("Reached - CartItemController - removeCardItemByID: "+ cartItemID);
        cartItemService.removeCartItem(Long.valueOf(cartItemID));
    }

    @GetMapping("/cart-items/cart-items-amount/{loginToken}")
    public Integer getTotalValueAmountProductsInCart(@PathVariable String loginToken){

       log.info("RESULT OF /cart-items-amount/{loginToken}: "+ cartItemService.getTotalValueAmountProductsInCart(loginToken));
       return cartItemService.getTotalValueAmountProductsInCart(loginToken);
    }
    //TODO : getTotalNumberOfItemsInCart(), removeCardItemByID TREBUIE SA FACA REFERIRE LA UN ANUME SESSION PE LANGA CELELALTE FILTRE !!
}
