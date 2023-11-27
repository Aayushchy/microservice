package com.user.service;

import com.user.dto.Account;
import com.user.routes.Routes;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "ACCOUNT-SERVICE")
public interface AccountClient {

    @RequestMapping(value = Routes.ACCOUNT_BALANCE_BY_ID, method = RequestMethod.GET)
    Account getBalance(@PathVariable Long userId);
}
