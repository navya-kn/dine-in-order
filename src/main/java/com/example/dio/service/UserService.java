package com.example.dio.service;

import com.example.dio.model.User;
import org.springframework.stereotype.Service;


public interface UserService {
   public  User registerUser(User user);

   User getUser(User user);
}
