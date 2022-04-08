package com.clockworkcode.pentagonbusinesscomv2.repository;

import com.clockworkcode.pentagonbusinesscomv2.model.shopping.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem,Long> {

//    void UPDATE CART ITEM QUANTITY => https://stackoverflow.com/questions/39741102/how-to-beautifully-update-a-jpa-entity-in-spring-data

    void deleteCartItemByCartItemID(Long cartItemID);

}
