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
import java.util.Optional;
import java.util.UUID;

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

    public String signUpUSer(AppUser appUser){

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

//        Optional<AppUser> user = appUserRepository.findByEmail(email);
//        String encodedInputPassword = user.get().getPassword();


        boolean accountExists = appUserRepository.findByEmail(email).isPresent();

        if(!accountExists){
            throw new IllegalStateException("Account does not exist!");
        }

        AppUser user = appUserRepository.findByEmailAndEnabledIsTrue(email);

        String sessionToken = UUID.randomUUID().toString();

        String encodedPassword = user.getPassword();
        String encodedInputPassword = bCryptPasswordEncoder.encode(password);

        if(encodedInputPassword.equals(encodedPassword)){

            log.info("PASSWORDS MATCH!");
            System.out.println("PASSWORDS MATCH!");

            LoginToken loginToken = new LoginToken(
                    sessionToken,
                    LocalDateTime.now(),
                    LocalDateTime.now().plusMinutes(100),user
            );
            loginTokenService.saveLoginToken(loginToken);
        }

        return sessionToken;
    }

    public int enableAppUser(String email) {

        return appUserRepository.enableAppUser(email);
    }
}
