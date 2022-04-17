package com.clockworkcode.pentagonbusinesscomv2.controller;
import com.clockworkcode.pentagonbusinesscomv2.model.login.LoginRequest;
import com.clockworkcode.pentagonbusinesscomv2.model.logout.LogoutRequest;
import com.clockworkcode.pentagonbusinesscomv2.service.LoginService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/e-shop")
@CrossOrigin(origins = "http://localhost:3000")
@AllArgsConstructor
@Slf4j
public class LoginController {

    private final LoginService loginService;

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request){

        String tokenResult = loginService.login(request);

        System.out.println("LoginController token result: "+tokenResult);

        return tokenResult;
    }

    @PostMapping("/logout")
    public void logout(@RequestBody LogoutRequest request){

//        log.info("reached logout route with loginToken: "+ request.getLoginToken());


        loginService.logout(request);

    }

//    @GetMapping("get-user-details/{userToken}")
//    public ResponseEntity<AppUser> getAppUser(@PathVariable String userToken){
//
//        AppUser loggedInUser = (AppUser) appUserService.getUserByToken(userToken);
//
//        return ResponseEntity.ok().body ((AppUser) appUserService.getUserByToken(userToken) );
//    }

}
