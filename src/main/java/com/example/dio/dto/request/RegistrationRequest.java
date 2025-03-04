package com.example.dio.dto.request;

import com.example.dio.enums.UserRole;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter

public class RegistrationRequest {
    @NotEmpty(message = "Username cannot be empty")
    @NotBlank(message = "Username cannot be blank")
    @Pattern(regexp = "^[a-zA-Z0-9_]+$" ,message = "Username can allow only Alphabets,Numbers and Underscore")
    private String username;

    @NotEmpty(message = "Email cannot be empty")
    @NotBlank(message = "Email cannot be blank")
    @Email(regexp = "^[a-zA-Z0-9._]+@gmail.com")
    private String email;

  @Pattern(regexp = "^(?=.*[!@#$%^&*(),.?\":{}|<>])(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}$",message = "Password must be contains 8 leeters,atleast one Uppercase,atleast One lowercase,atleast one number")
    private String password;
  @Pattern(regexp = "^[7-9]d{9}$" ,message = "invaild phno")
    private long phno;
    private UserRole role;
}
