package com.clockworkcode.pentagonbusinesscomv2.service;

import com.clockworkcode.pentagonbusinesscomv2.model.product.Product;
import com.clockworkcode.pentagonbusinesscomv2.model.shopping.CartItem;
import com.clockworkcode.pentagonbusinesscomv2.repository.CartItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CartItemService {

    private final ShoppingSessionService shoppingSessionService;
    private final CartItemRepository cartItemRepository;

    @Autowired
    public CartItemService(ShoppingSessionService shoppingSessionService, CartItemRepository cartItemRepository) {
        this.shoppingSessionService = shoppingSessionService;
        this.cartItemRepository = cartItemRepository;
    }


    public void addNewCartItem(String loginToken, Product product,Integer quantity){

        cartItemRepository.save(new CartItem(shoppingSessionService.getShoppingSessionByLoginToken(loginToken),product,quantity));

        log.info("New product "+product.getProductName()+" in quantity "+quantity+" was added to the Cart!");
    }

    public void updateCartItemQuantity(Long cartItemID, Integer quantity){

    }

    public void removeCartItem(Long cartItemID){

        cartItemRepository.deleteCartItemByCartItemID(cartItemID);
    }


}
