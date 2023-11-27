package com.account.service.impl;

import com.account.entity.Account;
import com.account.repository.AccountRepository;
import com.account.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    @Override
    public Account registerAccount(Account accountDetails) {
        return accountRepository.save(accountDetails);
    }

    @Override
    public List<Account> getAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public Account getAccountByUserId(Long userId) {
        return accountRepository.findById(userId).orElseThrow(() -> new RuntimeException("Not Found"));
    }
}
