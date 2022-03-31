package com.clockworkcode.pentagonbusinesscomv2.controller;

import com.clockworkcode.pentagonbusinesscomv2.model.registration.RegistrationRequest;
import com.clockworkcode.pentagonbusinesscomv2.service.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/e-shop/registration")
@CrossOrigin(origins = "http://localhost:3000")
@AllArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

    @PostMapping
    public String register(@RequestBody RegistrationRequest request){

        System.out.println("Register request: "+ request);

        return registrationService.register(request);
    }

    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token){
        return registrationService.confirmToken(token);
    }

}
