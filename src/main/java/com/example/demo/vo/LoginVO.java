package com.example.demo.vo;

import lombok.Data;

@Data
public class LoginVO {
    private String mobile;
    private String password;

    @Override
    public String toString() {
        return "LoginVO{" +
                "mobile='" + mobile + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
