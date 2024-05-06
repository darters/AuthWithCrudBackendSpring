package com.example.demo.payload.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class LoginRequest {
    @NotNull(message = "Email can't be empty")
    private String email;
    @NotNull(message = "Password can't be empty")
    private String password;
}
