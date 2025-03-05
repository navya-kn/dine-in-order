package com.example.dio.service.impl;

import com.example.dio.dto.request.RegistrationRequest;
import com.example.dio.dto.request.UserRequest;
import com.example.dio.dto.response.UserResponse;
import com.example.dio.enums.UserRole;
import com.example.dio.mapper.UserMapper;
import com.example.dio.model.Admin;
import com.example.dio.model.Staff;
import com.example.dio.model.User;
import com.example.dio.repository.UserRepository;
import com.example.dio.service.UserService;
import com.example.dio.exception.UserNotFoundByIdException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    /**
     *
     * @param registrationRequest The request object containing the user details for registration,
     *  *                            including fields such as username, email, password, etc.
     *  * @return object containing the details of the newly registered user.
     *  *         This response object includes relevant information about the user after the registration.
     * @return
     */
    @Override
    public UserResponse registerUser(RegistrationRequest registrationRequest) {
        User user = this.createUserByRole(registrationRequest.getRole());

        // this.mapToNewUser(user,user2);
        // this.mapToEntity(registrationRequest,user);
        userMapper.mapToEntity(registrationRequest, user);
        userRepository.save(user);
        return userMapper.mapToUserResponse(user);
    }

    @Override
    /**
     * * @param userId The ID of the user to be retrieved.
     *  * @return object containing the user's details.
     *  * @throws UserNotFoundByIdException if no user is found with the given userId
     */
    public UserResponse findUserById(long userId) {
//        User user= userRepository.findById(userId).orElseThrow(()-> new UserNotFoundByIdException("Faild to find user"));
//        return this.mapToUserResponse(user);
        return userRepository.findById(userId)
                .map(userMapper::mapToUserResponse)
                .orElseThrow(()-> new UserNotFoundByIdException("Faild to find user,user not found by id"));
    }

    /**
     *Updates the details of an existing user identified by the provided userId
     * @param userId userId The ID of the user to be updated. This should be a valid and existing user ID in the system.
     * @param userRequest userRequest The request object containing the updated information for the user
     * @return object containing the updated user information after the update is applied.
     *          This response object is returned to the client.
     */

    @Override
    public UserResponse updateUserById(long userId, UserRequest userRequest) {
        User existingUser = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundByIdException("Failed to update the user,user not found by id"));
        userMapper.mapToNewUser(userRequest, existingUser);
        User updatedUser = userRepository.save(existingUser);
        //  existingUser.setUsername(updatedUser.getUsername());
        return userMapper.mapToUserResponse(updatedUser);
    }

    /**
     * produces and returns child instance of the User based on the user role
     * @param role role of the user
     * @return User the parent reference containing either of staff or admin instance
     */

    private User createUserByRole(UserRole role){
        User user;
        switch (role){
            case ADMIN -> user = new Admin();
            case STAFF -> user = new Staff();
            default -> throw new RuntimeException("Failed to register user,invalid user Type!");
        }
        return  user;
    }

//    private void mapToNewUser(User source,User target){
//        target.setUsername(source.getUsername());
//        target.setEmail(source.getEmail());
//        target.setPassword(source.getPassword());
//        target.setRole(source.getRole());
//        target.setPhNo(source.getPhNo());
//        target.setCreatAt(source.getCreatAt());
//        target.setLastModifirdAt(source.getLastModifirdAt());
//    }


}
