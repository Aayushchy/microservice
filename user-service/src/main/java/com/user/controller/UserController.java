package com.user.controller;

import com.user.entity.User;
import com.user.routes.Routes;
import com.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@RequestMapping(Routes.USER)
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @RequestMapping(value = Routes.USERS, method = RequestMethod.GET)
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @RequestMapping(value = Routes.REGISTER, method = RequestMethod.POST)
    public User register(@RequestBody User userDetails) {
        return userService.registerUser(userDetails);
    }

    @RequestMapping(value = Routes.BALANCE, method = RequestMethod.GET)
    public List<User> getUsersBalance() {
        return userService.getUsersBalance();
    }
}
