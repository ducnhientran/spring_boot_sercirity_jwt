package com.study.ecommerce.service.impl;

import com.study.ecommerce.jwt.JwtTokenUtil;
import com.study.ecommerce.model.authentication.LoginDto;
import com.study.ecommerce.model.response.ResponseData;
import com.study.ecommerce.model.user.UserDetailsCustom;
import com.study.ecommerce.model.user.UserLogin;
import com.study.ecommerce.service.AuthenticationService;
import com.study.ecommerce.jwt.JwtUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final AuthenticationManager authenticationManager;

    private final JwtTokenUtil jwtTokenUtil;

    @Override
    public ResponseData authentication(UserLogin userLogin) {
        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userLogin.getUsername(), userLogin.getPassword()));
            return ResponseData.builder()
                    .data(LoginDto.builder().token(jwtTokenUtil.generateToken((UserDetailsCustom) authentication.getPrincipal())).build())
                    .status(HttpStatus.OK.value())
                    .message("Login Successful!")
                    .build();
        } catch (DisabledException e) {
            return ResponseData.builder()
                    .status(HttpStatus.BAD_REQUEST.value())
                    .message("User disable!")
                    .build();
        } catch (BadCredentialsException e) {
            return ResponseData.builder()
                    .status(HttpStatus.BAD_REQUEST.value())
                    .message("Invalid credentials!")
                    .build();
        }
    }
}
