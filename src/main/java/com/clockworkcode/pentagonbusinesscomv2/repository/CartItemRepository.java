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
    @Query(value = "UPDATE CartItem ci SET ci.quantity=ci.quantity+:increaseAmount WHERE ci.cartItemID=:cartItemId")
    void updateIncreaseCartItemQuantity(@Param("increaseAmount") Integer increaseAmount,@Param("cartItemId") Long cartItemId);

    void deleteCartItemByCartItemID(Long cartItemID);

//    void deleteCartItemsByShoppingSession_AppUser_AppUserID(Long appUserID);

    void deleteCartItemsByShoppingSession_LoginToken(LoginToken loginToken);

    @Query("select sum(quantity) from CartItem")
    Integer getTotalNumberOfItemsInCart();


//    @Query("select sum(CartItem.quantity*Product.productPrice) FROM CartItem WHERE ShoppingSession.loginToken.token=:loginToken")
//    @Query(value = "select sum(CartItem.quantity*Product.productPrice) FROM CartItem WHERE ShoppingSession.loginToken.token=:loginToken", nativeQuery = true) //cartitem not found - the closest
//    @Modifying
//    @Query( value = "SELECT sum( CartItem.product.productPrice*CartItem.quantity ) " +
//            "from CartItem " +
//            "JOIN Product ON CartItem.product.productID=Product.productID WHERE CartItem.shoppingSession.loginToken.token=:loginToken",nativeQuery = true)

//    @Query(
//            value = "SELECT sum( CartItem.product.productPrice*CartItem.quantity )" +
//                    "from CartItem " +
//                    "JOIN Product ON Product.productID=CartItem .product.productID JOIN ShoppingSession ON ShoppingSession .shoppingSessionID=CartItem .shoppingSession.shoppingSessionID " +
//                    "WHERE CartItem .shoppingSession.loginToken.token=:loginToken",nativeQuery = true // sau cu LIKE :loginToken
//    )
    @Query(
            value = "SELECT sum( cartitems.quantity * p.product_price )" +
                    "from cartitems " +
                    "JOIN products p ON p.productid = cartitems.productid JOIN shoppingsessions s ON s.shopping_sessionid = cartitems.shopping_sessionid WHERE cartitems.shopping_sessionid=:sessionID",nativeQuery = true
    )
    Integer getTotalValueOfItemsInCart(@Param("sessionID") Long sessionID);

}