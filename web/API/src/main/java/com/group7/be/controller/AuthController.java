package com.group7.be.controller;

import com.group7.be.dto.request.LoginRequest;
import com.group7.be.dto.request.RegisterRequest;
import com.group7.be.dto.response.BaseResponse;
import com.group7.be.dto.response.LoginResponse;
import com.group7.be.dto.response.UserInfoResponse;
import com.group7.be.model.User;
import com.group7.be.service.impl.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationService authenticationService;

    Logger logger = LoggerFactory.getLogger(AuthController.class);

    @PostMapping(value = "/login")
    public ResponseEntity<BaseResponse<LoginResponse>> login(@RequestBody LoginRequest request) {
        logger.info("vô login");
        return ResponseEntity.status(HttpStatus.OK).body(
                authenticationService.authenticate(request));
    }

    @PostMapping(value = "/register")
    public ResponseEntity<BaseResponse<String>> register(@RequestBody RegisterRequest request) {
        logger.info("vô register");
        return ResponseEntity.status(HttpStatus.OK).body(authenticationService.register(request));
    }

    @GetMapping(value = "/info")
    public ResponseEntity<BaseResponse<UserInfoResponse>> getInfo() {
        return ResponseEntity.status(HttpStatus.OK).body(authenticationService.getInfo());
    }
}
