package com.group7.be.enumerate;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Role {
    USER("ROLE_USER"), ADMIN("ROLE_ADMIN");
     private String value;
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
