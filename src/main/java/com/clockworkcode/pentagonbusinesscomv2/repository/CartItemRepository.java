package com.clockworkcode.pentagonbusinesscomv2.repository;

import com.clockworkcode.pentagonbusinesscomv2.model.shopping.CartItem;
import com.clockworkcode.pentagonbusinesscomv2.security.token.LoginToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface CartItemRepository extends JpaRepository<CartItem,Long> {

//    void UPDATE CART ITEM QUANTITY => https://stackoverflow.com/questions/39741102/how-to-beautifully-update-a-jpa-entity-in-spring-data

    @Modifying
    @Query(value = "update CartItem ci set ci.quantity=ci.quantity+:increaseAmount where ci.cartItemID=:cartItemId")
    void updateIncreaseCartItemQuantity(@Param("increaseAmount") Integer increaseAmount,@Param("cartItemId") Long cartItemId);

    void deleteCartItemByCartItemID(Long cartItemID);

//    void deleteCartItemsByShoppingSession_AppUser_AppUserID(Long appUserID);

    void deleteCartItemsByShoppingSession_LoginToken(LoginToken loginToken);

}

//1.	Dupa login => avem un token => il trimitem inapoin in backend =>
// il folosim pt a identifica cine este logat SAU salvam LOCAL rezultatul acelei methode si plecam de acolo