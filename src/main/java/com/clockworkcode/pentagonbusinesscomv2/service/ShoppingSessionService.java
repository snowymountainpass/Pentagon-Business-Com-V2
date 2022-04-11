package com.clockworkcode.pentagonbusinesscomv2.service;

import com.clockworkcode.pentagonbusinesscomv2.model.shopping.CartItem;
import com.clockworkcode.pentagonbusinesscomv2.model.shopping.ShoppingSession;
import com.clockworkcode.pentagonbusinesscomv2.model.user.AppUser;
import com.clockworkcode.pentagonbusinesscomv2.repository.ShoppingSessionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
@Slf4j
public class ShoppingSessionService {

    private final ShoppingSessionRepository shoppingSessionRepository;
    private final LoginTokenService loginTokenService;
    private final CartItemService cartItemService;

    @Autowired
    public ShoppingSessionService(ShoppingSessionRepository shoppingSessionRepository, LoginTokenService loginTokenService, CartItemService cartItemService) {
        this.shoppingSessionRepository = shoppingSessionRepository;
        this.loginTokenService = loginTokenService;
        this.cartItemService = cartItemService;
    }

    public void addNewShoppingSession(String loginToken){

        System.out.println("TOKEN: "+ loginToken);

        AppUser user = loginTokenService.getAppUserByLoginToken(loginToken);


        List<ShoppingSession> shoppingSessions = shoppingSessionRepository.findShoppingSessionsByAppUser_AppUserID(user.getAppUserID());

        if(shoppingSessions.size()==1){
            shoppingSessionRepository.deleteShoppingSessionsByAppUser_AppUserID(user.getAppUserID());
            log.info("Removed previous SHOPPING CART SESSION - user has logged out and the logging in!  ");

           if(
                   cartItemService.getCartItemsBySessionID(shoppingSessionRepository.findShoppingSessionByAppUser_AppUserID(user.getAppUserID()).getShoppingSessionID()).size()!=0
                   // IF SESSION HAS ANY DEPENDENTS => IF ANY ITEMS HAVE BEEN ADDED TO THE SHOPPING CART UNDER THE CURRENT SESSION
           ){
               cartItemService.deleteCartItemsBySessionID( shoppingSessionRepository.findShoppingSessionByAppUser_AppUserID(user.getAppUserID()).getShoppingSessionID() );
               log.info("Removed CART ITEMS FROM PREVIOUS SHOPPING CART SESSION - since user has logged out no need to keep them!  ");
               //TODO : AICI AM RAMAS - DE TESTAT!
           }
        }

        log.info("SHOPPING SESSION USER EMAIL: "+user.getEmail());

        Set<CartItem> cartItems = new HashSet<>();
        shoppingSessionRepository.save(new ShoppingSession(user, BigDecimal.valueOf(0),cartItems));

    }

    public ShoppingSession getShoppingSessionByLoginToken(String loginToken){

        AppUser user = loginTokenService.getAppUserByLoginToken(loginToken);

        return shoppingSessionRepository.findShoppingSessionByAppUser_AppUserID(user.getAppUserID());
    }

//    public ShoppingSession getShoppingSessionByAppUserID(Long appUserID){
//
//        ShoppingSession shoppingSession = shoppingSessionRepository.findShoppingSessionByAppUser_AppUserID(appUserID);
//
//        return shoppingSessionRepository.findShoppingSessionByAppUser_AppUserID(appUserID);
//    }
//
//    public void deleteShoppingSession (Long appUserID){
//        shoppingSessionRepository.delete( getShoppingSessionByAppUserID(appUserID)  );
//    }

}
