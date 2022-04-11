package com.clockworkcode.pentagonbusinesscomv2.repository;

import com.clockworkcode.pentagonbusinesscomv2.model.shopping.ShoppingSession;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShoppingSessionRepository extends JpaRepository<ShoppingSession,Long> {

    ShoppingSession findShoppingSessionByAppUser_AppUserID(Long appUserID);
    List<ShoppingSession> findShoppingSessionsByAppUser_AppUserID(Long appUserID);

    void deleteShoppingSessionsByAppUser_AppUserID(Long appUserID);
}
