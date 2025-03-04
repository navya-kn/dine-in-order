package com.example.dio.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {
    @NotEmpty(message = "Username cannot be empty")
    @NotBlank(message = "Username cannot be blank")
    private String username;
    @NotEmpty(message = "Email cannot be empty")

    @NotBlank(message = "Email cannot be blank")
    @Pattern(regexp = "^(?=.*[!@#$%^&*(),.?\":{}|<>])(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}$",message = "Password must be contains 8 leeters,atleast one Uppercase,atleast One lowercase,atleast one number")

    private String email;
    @Pattern(regexp = "^[7-9]d{9}$" ,message = "invaild phno")
    @NotEmpty(message = "Phno cannot be empty")
    @NotBlank(message = "Phno cannot be blank")
    private long phno;
}
