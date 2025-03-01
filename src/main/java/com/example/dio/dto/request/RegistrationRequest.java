package com.example.dio.dto.request;

import com.example.dio.enums.UserRole;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationRequest {
    private String username;
    private String email;
    private String password;
    private long phno;
    private UserRole role;
}
