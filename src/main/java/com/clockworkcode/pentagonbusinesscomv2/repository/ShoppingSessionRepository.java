package com.clockworkcode.pentagonbusinesscomv2.repository;

import com.clockworkcode.pentagonbusinesscomv2.model.shopping.ShoppingSession;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShoppingSessionRepository extends JpaRepository<ShoppingSession,Long> {

//    ShoppingSession findShoppingSessionByAppUser_AppUserID(Long appUserID);
//    List<ShoppingSession> findShoppingSessionsByAppUser_AppUserID(Long appUserID);
//
//    void deleteShoppingSessionsByAppUser_AppUserID(Long appUserID);

    ShoppingSession findShoppingSessionByLoginToken_Token(String loginToken);

//    List<ShoppingSession> findShoppingSessionsByLoginToken_Token(String loginToken);
    List<ShoppingSession> findShoppingSessionsByLoginToken_Id(Long loginTokenID);

//    void deleteShoppingSessionByLoginToken_Token(String loginToken);
    void deleteShoppingSessionByLoginToken_Id(Long loginTokenID);

}
