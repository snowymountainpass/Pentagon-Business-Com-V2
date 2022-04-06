package com.clockworkcode.pentagonbusinesscomv2.controller;

import com.clockworkcode.pentagonbusinesscomv2.model.login.LoginRequest;
import com.clockworkcode.pentagonbusinesscomv2.model.user.AppUser;
import com.clockworkcode.pentagonbusinesscomv2.service.AppUserService;
import com.clockworkcode.pentagonbusinesscomv2.service.LoginService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/e-shop")
@CrossOrigin(origins = "http://localhost:3000")
@AllArgsConstructor
public class LoginController {

    private final LoginService loginService;
    private final AppUserService appUserService;

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request){

        String tokenResult = loginService.login(request);

        System.out.println("LoginController token result: "+tokenResult);

        return tokenResult;
    }

//    @GetMapping("get-user-details/{userToken}")
//    public ResponseEntity<AppUser> getAppUser(@PathVariable String userToken){
//
//        AppUser loggedInUser = (AppUser) appUserService.getUserByToken(userToken);
//
//        return ResponseEntity.ok().body ((AppUser) appUserService.getUserByToken(userToken) );
//    }

}