package com.group7.be.service.impl;

import com.group7.be.dto.request.LoginRequest;
import com.group7.be.dto.request.RegisterRequest;
import com.group7.be.dto.response.BaseResponse;
import com.group7.be.dto.response.LoginResponse;
import com.group7.be.dto.response.UserInfoResponse;
import com.group7.be.enumerate.Role;
import com.group7.be.model.User;
import com.group7.be.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final JwtService jwtService;
    private final IUserRepository userRepository;
    private final AuthenticationManager authenticationManager;

    private final PasswordEncoder passwordEncoder;

    public BaseResponse<LoginResponse> authenticate(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        User user = userRepository.findUserByUsername(request.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("user not found"));
        String jwtToken = jwtService.generateToken(user, new HashMap<>());

        LoginResponse loginResponse = LoginResponse.builder().token(jwtToken).build();

        return BaseResponse.<LoginResponse>builder()
                .data(loginResponse)
                .message("login success !")
                .code(HttpStatus.OK.value())
                .build();
    }
    public BaseResponse register(RegisterRequest request) {
        User user = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .build();
        userRepository.save(user);

        return BaseResponse
                .builder()
                .message("Create account success !")
                .code(200)
                .data("")
                .build();
    }

    public BaseResponse<UserInfoResponse> getInfo() {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findUserByUsername(name).orElseThrow(() -> new UsernameNotFoundException("user not found"));;

        UserInfoResponse userInfoResponse = UserInfoResponse.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .role(user.getRole())
                .username(user.getUsername())
                .build();

        return BaseResponse.<UserInfoResponse> builder()
                .data(userInfoResponse)
                .message("getInfo success !")
                .code(HttpStatus.OK.value())
                .build();
    }
}
