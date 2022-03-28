package com.clockworkcode.pentagonbusinesscomv2.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/registration")
@CrossOrigin(origins = "http://localhost:3000/e-shop")
@AllArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;



}
