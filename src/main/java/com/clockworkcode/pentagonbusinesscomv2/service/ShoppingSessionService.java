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

    @Autowired
    public ShoppingSessionService(ShoppingSessionRepository shoppingSessionRepository, LoginTokenService loginTokenService) {
        this.shoppingSessionRepository = shoppingSessionRepository;
        this.loginTokenService = loginTokenService;
    }

    public void addNewShoppingSession(String loginToken){

        System.out.println("TOKEN: "+ loginToken);

        AppUser user = loginTokenService.getAppUserByLoginToken(loginToken);


        List<ShoppingSession> shoppingSessions = shoppingSessionRepository.findShoppingSessionsByAppUser_AppUserID(user.getAppUserID());

        if(shoppingSessions.size()==1){
            shoppingSessionRepository.deleteShoppingSessionsByAppUser_AppUserID(user.getAppUserID());
            log.info("Removed previous SHOPPING CART SESSION - user has logged out and the logging in!  ");
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