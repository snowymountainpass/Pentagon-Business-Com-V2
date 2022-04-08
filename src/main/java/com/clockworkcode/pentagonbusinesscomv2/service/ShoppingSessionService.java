package com.clockworkcode.pentagonbusinesscomv2.service;

import com.clockworkcode.pentagonbusinesscomv2.model.shopping.CartItem;
import com.clockworkcode.pentagonbusinesscomv2.model.shopping.ShoppingSession;
import com.clockworkcode.pentagonbusinesscomv2.model.user.AppUser;
import com.clockworkcode.pentagonbusinesscomv2.repository.ShoppingSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Service
public class ShoppingSessionService {

    private final ShoppingSessionRepository shoppingSessionRepository;
    private final ConfirmationTokenService confirmationTokenService;

    @Autowired
    public ShoppingSessionService(ShoppingSessionRepository shoppingSessionRepository, ConfirmationTokenService confirmationTokenService) {
        this.shoppingSessionRepository = shoppingSessionRepository;
        this.confirmationTokenService = confirmationTokenService;
    }

    public void addNewShoppingSession(String confirmationToken){

        System.out.println("TOKEN: "+ confirmationToken);

        AppUser user = confirmationTokenService.getAppUserByConfirmationToken(confirmationToken);

        System.out.println("SHOPPING SESSION USER EMAIL: "+user.getEmail());

        Set<CartItem> cartItems = new HashSet<>();
        shoppingSessionRepository.save(new ShoppingSession(user, BigDecimal.valueOf(0),cartItems));

    }

}
