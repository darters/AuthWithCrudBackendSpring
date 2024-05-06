package com.example.demo.payload.request;

import lombok.Data;

@Data
public class SignupRequest {
    private String email;
    private String fullName;
    private String password;
}
