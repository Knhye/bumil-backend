package com.example.bumil_backend.dto.user.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class DeleteUserRequest {
    @NotBlank
    private String refreshToken;
}
