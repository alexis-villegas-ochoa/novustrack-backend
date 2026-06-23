package io.novustrack.backend.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {
    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size (min = 8, message = "Password must be at least 8 characters long for security")
    private String password;

}
