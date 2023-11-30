package com.user.service.impl;

import com.user.dto.Account;
import com.user.entity.User;
import com.user.repository.UserRepository;
import com.user.service.AccountClient;
import com.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final AccountClient accountClient;
    private final WebClient webClient;

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
                .peek(user -> user.setBalance(accountClient.getBalance(user.getId()).getBalance()))
                .toList();

    }

    @Override
    public List<User> getAllUsersBalance() {

        List<Account> accounts = getAccounts();
        if (accounts == null || accounts.isEmpty())
            throw new RuntimeException("Empty Account Data for user");

        List<User> userList = userRepository.findAll();
        userList.forEach(user -> accounts.stream()
                .filter(account -> account.getUserId().equals(user.getId()))
                .findFirst()
                .ifPresent(account -> user.setBalance(account.getBalance())));

        return userList;

    }

    private List<Account> getAccounts() {

        Flux<Account> accountFlux = webClient.get()
                .uri("/accounts")
                .retrieve()
                .bodyToFlux(Account.class);

        Mono<List<Account>> accountMono = accountFlux.collectList();
        return accountMono.block();
    }
}
