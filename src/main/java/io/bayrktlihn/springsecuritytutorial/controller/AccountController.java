package io.bayrktlihn.springsecuritytutorial.controller;

import io.bayrktlihn.springsecuritytutorial.model.Account;
import io.bayrktlihn.springsecuritytutorial.model.Customer;
import io.bayrktlihn.springsecuritytutorial.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AccountController {

    private final AccountRepository accountRepository;

    @PostMapping("myAccount")
    public Account getAccountDetails(@RequestBody Customer customer) {
        return accountRepository.findByCustomerCustomerId(customer.getCustomerId());
    }

}
