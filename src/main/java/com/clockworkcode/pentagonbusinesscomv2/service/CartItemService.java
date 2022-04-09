package com.clockworkcode.pentagonbusinesscomv2.service;

import com.clockworkcode.pentagonbusinesscomv2.model.product.Product;
import com.clockworkcode.pentagonbusinesscomv2.model.shopping.CartItem;
import com.clockworkcode.pentagonbusinesscomv2.repository.CartItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@Slf4j
public class CartItemService {

    private final ShoppingSessionService shoppingSessionService;
    private final CartItemRepository cartItemRepository;
    private final ProductDBService productDBService;

    @Autowired
    public CartItemService(ShoppingSessionService shoppingSessionService, CartItemRepository cartItemRepository, ProductDBService productDBService) {
        this.shoppingSessionService = shoppingSessionService;
        this.cartItemRepository = cartItemRepository;
        this.productDBService = productDBService;
    }


    public void addNewCartItem(String loginToken, Long productId,Integer quantity){

        Product product = productDBService.getProductByProductID(String.valueOf(productId));

        cartItemRepository.save(new CartItem(shoppingSessionService.getShoppingSessionByLoginToken(loginToken),product,quantity));

        log.info("New product "+product.getProductName()+" in quantity "+quantity+" was added to the Cart!");
    }

    public void updateCartItemQuantity(String loginToken, Long productId, Integer quantity){

       CartItem itemInCart = cartItemRepository.findAll().stream().filter(cartItem -> cartItem.getProduct().getProductID().equals(productId)).collect(Collectors.toList()).get(0);

        if( itemInCart!=null ){
            itemInCart.setQuantity(quantity);
        }
        else {
            addNewCartItem(loginToken,productId,quantity);
        }
    }

    public void removeCartItem(Long cartItemID){

        cartItemRepository.deleteCartItemByCartItemID(cartItemID);
    }


}
