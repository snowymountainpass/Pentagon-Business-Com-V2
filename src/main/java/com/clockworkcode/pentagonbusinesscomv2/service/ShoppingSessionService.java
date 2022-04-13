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

        log.info("addNewShoppingSession-1 => TOKEN - addNewShoppingSession : "+ loginToken);

        AppUser user = loginTokenService.getAppUserByLoginToken(loginToken);


//        List<ShoppingSession> shoppingSessions = shoppingSessionRepository.findShoppingSessionsByAppUser_AppUserID(user.getAppUserID());
//        List<ShoppingSession> shoppingSessions = shoppingSessionRepository.findShoppingSessionByLoginToken( loginTokenService.getToken(loginToken));

//        List<ShoppingSession> shoppingSessions = shoppingSessionRepository.findShoppingSessionsByLoginToken_Token(loginToken);

        List<ShoppingSession> shoppingSessions = shoppingSessionRepository.findShoppingSessionsByLoginToken_Id( loginTokenService.getToken( loginToken ).getId() );

        log.info("addNewShoppingSession-2 => shoppingSessions (@ addNewShoppingSession) LIST SIZE:  "+ shoppingSessions.size() + " => NUMBER OF SESSIONS CURRENTLY IN THE DB");

        if(shoppingSessions.size()==1){
//            shoppingSessionRepository.deleteShoppingSessionsByAppUser_AppUserID(user.getAppUserID());
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

//        log.info("addNewShoppingSession-3 => SHOPPING SESSION USER EMAIL: "+user.getEmail());

        Set<CartItem> cartItems = new HashSet<>();
        shoppingSessionRepository.save(new ShoppingSession( loginTokenService.getToken(loginToken) , BigDecimal.valueOf(0),cartItems));

    }

    public ShoppingSession getShoppingSessionByLoginToken(String loginToken){

        AppUser user = loginTokenService.getAppUserByLoginToken(loginToken);

        return shoppingSessionRepository.findShoppingSessionByLoginToken_Token(loginToken);
    }

//    public ShoppingSession getShoppingSessionByAppUserID(Long appUserID){
//
//        ShoppingSession shoppingSession = shoppingSessionRepository.findShoppingSessionByAppUser_AppUserID(appUserID);
//
//        return shoppingSessionRepository.findShoppingSessionByAppUser_AppUserID(appUserID);
//    }

//    public void deleteShoppingSession (String loginToken){
//        shoppingSessionRepository.delete( getShoppingSessionByLoginToken(loginToken)  );
//    }

}
