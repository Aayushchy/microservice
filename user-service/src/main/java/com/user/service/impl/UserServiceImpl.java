package com.user.service.impl;

import com.user.entity.User;
import com.user.repository.UserRepository;
import com.user.service.AccountClient;
import com.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final AccountClient accountClient;
    @Override
    public User registerUser(User userDetails) {
        return userRepository.save(userDetails);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<User> getUsersBalance() {

        return userRepository.findAll().stream()
                .peek(user -> user.setBalance(accountClient.getBalance(user.getId()).getBalance())).toList();

    }
}
