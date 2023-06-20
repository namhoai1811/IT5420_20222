package com.group7.be.dto.response;

import lombok.Builder;

@Builder
public class LoginResponse {
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
