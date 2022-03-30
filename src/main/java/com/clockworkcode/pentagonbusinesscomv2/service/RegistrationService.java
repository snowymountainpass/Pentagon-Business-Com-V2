package com.clockworkcode.pentagonbusinesscomv2.service;

import com.clockworkcode.pentagonbusinesscomv2.model.registration.RegistrationRequest;
import com.clockworkcode.pentagonbusinesscomv2.model.user.AppUser;
import com.clockworkcode.pentagonbusinesscomv2.model.user.AppUserRole;
import com.clockworkcode.pentagonbusinesscomv2.security.token.ConfirmationToken;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
@Slf4j
public class RegistrationService {

    private final AppUserService appUserService;
    private final ConfirmationTokenService confirmationTokenService;
    private final EmailValidator emailValidator;

    public String register(RegistrationRequest request){

        boolean isValidEmail = emailValidator.test(request.getEmail());

        if(!isValidEmail){
            throw new IllegalStateException("email is not valid");
        }

        String token = appUserService.signUpUSer(

                new AppUser(
                        request.getEmail(),
                        request.getPassword()
                )

        );

        log.info("user has been registered!");
        return token;

    }

    @Transactional
    public String confirmToken(String token){
        ConfirmationToken confirmationToken = confirmationTokenService.getToken(token).orElseThrow(
                ()-> new IllegalStateException("token not found!")
        );

        if(confirmationToken.getConfirmedAt()!=null){
            throw new IllegalStateException("email has already been confirmed!");
        }

        LocalDateTime expiredAt = confirmationToken.getExpiresAt();

        if(expiredAt.isBefore(LocalDateTime.now())){
            throw new IllegalStateException("token expired!");
        }

        confirmationTokenService.setConfirmedAt(token);

        appUserService.enableAppUser(confirmationToken.getAppUser().getEmail());

        return "user confirmed!";
    }


}
