package com.example.dio.service;

import com.example.dio.dto.request.RegistrationRequest;
import com.example.dio.dto.request.UserRequest;
import com.example.dio.dto.response.UserResponse;

public interface UserService {

   /**
    *
    * @param registrationRequest registrationRequest The registration details of the users..

    * @return newly registered user's details.
    */
   public UserResponse registerUser(RegistrationRequest registrationRequest);

   /**
    *
    * @param userId   userId The ID of the user to be retrieved.
    * @return containing the user's details.
    */
   public  UserResponse findUserById(long userId);

   /**
    *
    * @param userId userId The ID of the user to be updated.
    * @param userRequest The user data to update the existing user's information
    * @return containing the updated user's details.
    */
   public UserResponse updateUserById(long userId, UserRequest userRequest);


}
