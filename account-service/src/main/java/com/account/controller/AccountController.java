package com.account.controller;

import com.account.entity.Account;
import com.account.routes.Routes;
import com.account.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RequestMapping(Routes.ACCOUNT)
@RestController
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @RequestMapping(value = Routes.ACCOUNTS, method = RequestMethod.GET)
    public List<Account> getAccounts() {
        return accountService.getAccounts();
    }

    @RequestMapping(value = Routes.BALANCE, method = RequestMethod.GET)
    public Account getAccountByUserId(@PathVariable Long userId) {
        return accountService.getAccountByUserId(userId);
    }

    @RequestMapping(value = Routes.REGISTER, method = RequestMethod.POST)
    public Account registerAccount(@RequestBody Account accountDetails) {
        return accountService.registerAccount(accountDetails);
    }
}
