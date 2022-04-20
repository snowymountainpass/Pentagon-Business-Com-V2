package com.clockworkcode.pentagonbusinesscomv2.service;

import com.clockworkcode.pentagonbusinesscomv2.model.product.Product;
import com.clockworkcode.pentagonbusinesscomv2.model.shopping.CartItem;
import com.clockworkcode.pentagonbusinesscomv2.model.shopping.ShoppingSession;
import com.clockworkcode.pentagonbusinesscomv2.model.user.AppUser;
import com.clockworkcode.pentagonbusinesscomv2.repository.ShoppingSessionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;


@Service
@Transactional
@Slf4j
public class ShoppingSessionService {

    private final ShoppingSessionRepository shoppingSessionRepository;
    private final LoginTokenService loginTokenService;

    @Autowired
    public ShoppingSessionService(ShoppingSessionRepository shoppingSessionRepository, LoginTokenService loginTokenService) {
        this.shoppingSessionRepository = shoppingSessionRepository;
        this.loginTokenService = loginTokenService;
    }

    public void addNewShoppingSession(String loginToken){

        log.info("addNewShoppingSession-1 => TOKEN - addNewShoppingSession : "+ loginToken);

        AppUser user = loginTokenService.getAppUserByLoginToken(loginToken);

        List<ShoppingSession> shoppingSessions = shoppingSessionRepository.findShoppingSessionsByLoginToken_Id( loginTokenService.getToken( loginToken ).getId() );

        log.info("addNewShoppingSession-2 => shoppingSessions (@ addNewShoppingSession) LIST SIZE:  "+ shoppingSessions.size() + " => NUMBER OF SESSIONS CURRENTLY IN THE DB");

        if(shoppingSessions.size()==1){
            log.info("CASE - shoppingSessions.size()==1");
            log.info("shoppingSessions.size()==1 -1=> shoppingSessions.get(0).getLoginToken().getId(): "+shoppingSessions.get(0).getLoginToken().getId());
            log.info("shoppingSessions.size()==1 -2=> Number of shopping sessions (for userID "
                    +user.getAppUserID()+" BEFORE DELETION is: "
                    + shoppingSessions.size()
            );

            log.info("LoginToken_Id to be used in -- shoppingSessionRepository.deleteShoppingSessionByLoginToken_Id : "+shoppingSessions.get(0).getLoginToken().getId());
            shoppingSessionRepository.deleteShoppingSessionByLoginToken_Id(shoppingSessions.get(0).getLoginToken().getId());
            log.info("shoppingSessions.size()==1 -3=> Number of shopping sessions (for userID "+user.getAppUserID()+" AFTER DELETION is: " +shoppingSessions);
            log.info("shoppingSessions.size()==1 -4=> Removed previous SHOPPING CART SESSION - user has logged out and the logging in!  ");
        }


        Set<CartItem> cartItems = new HashSet<>();
        shoppingSessionRepository.save(new ShoppingSession( loginTokenService.getToken(loginToken) , BigDecimal.valueOf(0),cartItems));

    }

    public ShoppingSession getShoppingSessionByLoginToken(String loginToken){

        AppUser user = loginTokenService.getAppUserByLoginToken(loginToken);

        return shoppingSessionRepository.findShoppingSessionByLoginToken_Token(loginToken);
    }

    public Hashtable<Long,List<String>> getListProductsAndQuantities(String loginToken){

        log.info("ShoppingSessionService -> reached getListProductsAndQuantities ("+loginToken+")");

//        ShoppingSession shoppingSession = shoppingSessionRepository.findShoppingSessionByLoginToken_Token(loginToken);
//        List<CartItem> cartItemsInShoppingSession = new ArrayList<>(shoppingSession.getCartItems());
//        Hashtable<Product,Integer> productsQuantitiesInShoppingSession = new Hashtable<>();
//        cartItemsInShoppingSession.forEach(cartItem -> productsQuantitiesInShoppingSession.put(cartItem.getProduct(),cartItem.getQuantity()));
//        log.info("productsQuantitiesInShoppingSession SIZE: "+String.valueOf(productsQuantitiesInShoppingSession.size()));
//        return productsQuantitiesInShoppingSession;

        ShoppingSession shoppingSession = shoppingSessionRepository.findShoppingSessionByLoginToken_Token(loginToken);
        List<CartItem> cartItemsInShoppingSession = new ArrayList<>(shoppingSession.getCartItems());
        Hashtable<Long,List<String>> productsQuantitiesInShoppingSession = new Hashtable<>();
        cartItemsInShoppingSession
                .forEach(
                        cartItem -> {
                            List<String> newArray = new ArrayList<>();
                            Collections.addAll(newArray,
                                    cartItem.getCartItemID().toString(),
                                    cartItem.getProduct().getProductName(),
                                    cartItem.getProduct().getProductDescription(),
                                    cartItem.getProduct().getDatasheet(),
                                    cartItem.getQuantity().toString(),
                                    cartItem.getProduct().getProductPrice().toString(),
//                                    cartItem.getProduct().getDiscounts().stream().findFirst().get().getDiscountPercent().toString(),
                                    cartItem.getProduct().getImg()
                            );
                            productsQuantitiesInShoppingSession
                                    .put(cartItem.getCartItemID(),newArray );
                        });


        return productsQuantitiesInShoppingSession;
    }

//    cartItem.getProduct().getProductName(),
//                                            cartItem.getProduct().getProductBrand(),
//                                            cartItem.getProduct().getProductPrice(),
//                                            cartItem.getProduct().getDiscounts(),
//                                            cartItem.getProduct().getProductDescription(),
//                                            cartItem.getProduct().getImg() )


//    public void deleteShoppingSession (String loginToken){
//        shoppingSessionRepository.delete( getShoppingSessionByLoginToken(loginToken)  );
//    }

}
