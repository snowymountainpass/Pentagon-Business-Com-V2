package com.clockworkcode.pentagonbusinesscomv2.service;

import com.clockworkcode.pentagonbusinesscomv2.model.user.AppUser;
import com.clockworkcode.pentagonbusinesscomv2.repository.AppUserRepository;
import com.clockworkcode.pentagonbusinesscomv2.security.PasswordEncoder;
import com.clockworkcode.pentagonbusinesscomv2.security.token.ConfirmationToken;
import com.clockworkcode.pentagonbusinesscomv2.security.token.LoginToken;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class AppUserService implements UserDetailsService {

    private final static String USER_NOT_FOUND_message = "user with email %s not found";
    private final AppUserRepository appUserRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ConfirmationTokenService confirmationTokenService;
    private final LoginTokenService loginTokenService;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return appUserRepository.findByEmail(email).orElseThrow(()->new UsernameNotFoundException(String.format(USER_NOT_FOUND_message,email)));
    }

    public String signUpUser(AppUser appUser){

        boolean userExists = appUserRepository.findByEmail(appUser.getEmail()).isPresent();

        if(userExists){
            throw new IllegalStateException("email already taken!");
        }

        String encodedPassword = bCryptPasswordEncoder.encode(appUser.getPassword());

        appUser.setPassword(encodedPassword);

        appUserRepository.save(appUser);

        String token = UUID.randomUUID().toString();

        ConfirmationToken confirmationToken = new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(25),appUser
        );
        confirmationTokenService.saveConfirmationToken(confirmationToken);
        log.info("user has been signed up! - AppUserService");

        return token;
    }

    public String signInUser(String email, String password){

        log.info("REACHED signInUser METHOD!");

        boolean accountExists = appUserRepository.findByEmail(email).isPresent();

        if(!accountExists){
            throw new IllegalStateException("Account does not exist!");
        }

        AppUser user = appUserRepository.findByEmailAndEnabledIsTrue(email);

        String sessionToken="";

        if(bCryptPasswordEncoder.matches(password,user.getPassword())){
            sessionToken = UUID.randomUUID().toString();
            log.info("PASSWORDS MATCH!");
            System.out.println("PASSWORDS MATCH!");

            if(loginTokenService.getTokensForAppUserID(user.getAppUserID()).size()==1){
                loginTokenService.deleteLoginToken(user.getAppUserID());
                log.info("Previous login token for appUser "+user.getAppUserID()+" was deleted!");
            }

            LoginToken loginToken = new LoginToken(
                    sessionToken,
                    LocalDateTime.now(),
                    LocalDateTime.now().plusMinutes(100),user
            );
            loginTokenService.saveLoginToken(loginToken);
        }

        if(!Objects.equals(sessionToken, "")){
            return sessionToken;
        }
        else{
            return "invalid credentials";
        }

    }

    public int enableAppUser(String email) {

        return appUserRepository.enableAppUser(email);
    }

//    public Object getUserByToken(String userToken) {
//
//        List<LoginToken> loginTokenList = loginTokenService.getToken(userToken).stream().collect(Collectors.toList());
//
//        return loginTokenList.get(0);
//    }
}
