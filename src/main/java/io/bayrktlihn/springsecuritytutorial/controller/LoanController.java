package io.bayrktlihn.springsecuritytutorial.controller;

import io.bayrktlihn.springsecuritytutorial.model.Customer;
import io.bayrktlihn.springsecuritytutorial.model.Loan;
import io.bayrktlihn.springsecuritytutorial.repository.LoanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LoanController {

    private final LoanRepository loanRepository;

    @PostMapping("myLoans")
    @PostAuthorize("hasRole('ROOT')")
    public List<Loan> getLoanDetails(@RequestBody Customer customer) {
        return loanRepository.findByCustomerCustomerIdOrderByStartDtDesc(customer.getCustomerId());
    }

}
