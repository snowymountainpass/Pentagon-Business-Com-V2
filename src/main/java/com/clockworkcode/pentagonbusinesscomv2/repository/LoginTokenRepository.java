package com.clockworkcode.pentagonbusinesscomv2.repository;



import com.clockworkcode.pentagonbusinesscomv2.security.token.LoginToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoginTokenRepository extends JpaRepository<LoginToken,Long> {
    LoginToken findByToken(String token);
    void deleteLoginTokenByAppUser_AppUserID(Long appUserID);

    //TODO - METHOD FOR REMOVING TOKEN AFTER IT HAS EXPIRED
}
