package com.example.bumil_backend.dto.user.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class SignupRequest {
    @NotBlank
    private String email;

    @NotBlank
    private String name;

    @NotBlank
    private String password;
}
