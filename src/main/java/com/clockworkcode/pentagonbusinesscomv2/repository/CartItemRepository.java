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

    @Modifying
    @Query(value = "UPDATE CartItem ci SET ci.quantity=ci.quantity+:increaseAmount WHERE ci.cartItemID=:cartItemId")
    void updateIncreaseCartItemQuantity(@Param("increaseAmount") Integer increaseAmount,@Param("cartItemId") Long cartItemId);

    void deleteCartItemByCartItemID(Long cartItemID);

    void deleteCartItemsByShoppingSession_LoginToken(LoginToken loginToken);

    @Query("select sum(quantity) from CartItem")
    Integer getTotalNumberOfItemsInCart();

    @Query(
            value = "SELECT sum( cartitems.quantity * p.product_price )" +
                    "from cartitems " +
                    "JOIN products p ON p.productid = cartitems.productid JOIN shoppingsessions s ON s.shopping_sessionid = cartitems.shopping_sessionid WHERE cartitems.shopping_sessionid=:sessionID",nativeQuery = true
    )
    Integer getTotalValueOfItemsInCart(@Param("sessionID") Long sessionID);

}