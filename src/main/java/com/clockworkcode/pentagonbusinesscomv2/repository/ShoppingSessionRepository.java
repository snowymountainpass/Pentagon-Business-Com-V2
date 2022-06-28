package com.clockworkcode.pentagonbusinesscomv2.repository;

import com.clockworkcode.pentagonbusinesscomv2.model.shopping.ShoppingSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShoppingSessionRepository extends JpaRepository<ShoppingSession,Long> {
    ShoppingSession findShoppingSessionByLoginToken_Token(String loginToken);

    List<ShoppingSession> findShoppingSessionsByLoginToken_Id(Long loginTokenID);

    void deleteShoppingSessionByLoginToken_Id(Long loginTokenID);

}
