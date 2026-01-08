package com.example.bumil_backend.dto.user.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserPasswordUpdateRequest {
    @NotBlank
    private String currentPassword;

    @NotBlank
    private String newPassword;
}
