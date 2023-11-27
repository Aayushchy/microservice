package com.user.service;

import com.user.entity.User;

import java.util.List;

public interface UserService {
    User registerUser(User user);

    List<User> getUsers();

    List<User> getUsersBalance();

}
