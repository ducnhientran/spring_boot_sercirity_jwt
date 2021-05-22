package com.study.ecommerce.controller;

import com.study.ecommerce.model.response.ResponseData;
import com.study.ecommerce.model.user.UserLogin;
import com.study.ecommerce.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthenticationController {

    @Autowired
    AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<ResponseData> login(@RequestBody UserLogin userLogin){
        return ResponseEntity.ok(authenticationService.authentication(userLogin));
    }




}
