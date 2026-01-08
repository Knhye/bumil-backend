package com.example.bumil_backend.dto.user.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LogoutRequest {
    @NotBlank
    private String refreshToken;
}
