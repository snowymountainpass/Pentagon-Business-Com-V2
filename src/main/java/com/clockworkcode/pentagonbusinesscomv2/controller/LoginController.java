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
        log.info("LoginController token result: "+tokenResult);
        return tokenResult;
    }

    @PostMapping("/logout")
    public void logout(@RequestBody LogoutRequest request){
        loginService.logout(request);
    }

}
