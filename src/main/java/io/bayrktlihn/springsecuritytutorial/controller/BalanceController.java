package io.bayrktlihn.springsecuritytutorial.controller;

import io.bayrktlihn.springsecuritytutorial.model.AccountTransaction;
import io.bayrktlihn.springsecuritytutorial.model.Customer;
import io.bayrktlihn.springsecuritytutorial.repository.AccountTransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BalanceController {

    private final AccountTransactionRepository accountTransactionRepository;

    @PostMapping("myBalance")
    public List<AccountTransaction> getBalanceDetails(@RequestBody Customer customer) {
        return accountTransactionRepository.findByCustomerCustomerIdOrderByTransactionDtDesc(customer.getCustomerId());
    }
}
