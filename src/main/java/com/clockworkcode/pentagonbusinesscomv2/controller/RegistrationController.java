package com.clockworkcode.pentagonbusinesscomv2.controller;

import com.clockworkcode.pentagonbusinesscomv2.model.request.RegistrationRequest;
import com.clockworkcode.pentagonbusinesscomv2.service.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping(path = "/e-shop")
@CrossOrigin(origins = "http://localhost:3000")
@AllArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

    @PostMapping("/registration")
    public String register(@RequestBody RegistrationRequest request){

        System.out.println("Register request: "+ request);

        return registrationService.register(request);
    }

    @GetMapping(path = "/registration/confirm")
    public ResponseEntity<Object> confirm(@RequestParam("token") String token, HttpServletResponse httpResponse) throws IOException {

        registrationService.confirmToken(token);
        return ResponseEntity.status(HttpStatus.MOVED_PERMANENTLY).header(HttpHeaders.LOCATION, "http://localhost:3000/e-shop").build();
    }

}
