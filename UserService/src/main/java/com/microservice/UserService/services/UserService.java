package com.microservice.UserService.services;

import com.microservice.UserService.entities.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);
    List<User> getAllUsers();
    User getUserById(String usrId);
}
