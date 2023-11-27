package com.account.service;

import com.account.entity.Account;

import java.util.List;

public interface AccountService {
    Account registerAccount(Account account);

    List<Account> getAccounts();

    Account getAccountByUserId(Long userId);

}
