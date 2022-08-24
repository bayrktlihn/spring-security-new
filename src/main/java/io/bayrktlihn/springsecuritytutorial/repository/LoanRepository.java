package io.bayrktlihn.springsecuritytutorial.repository;

import io.bayrktlihn.springsecuritytutorial.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

public interface LoanRepository extends JpaRepository<Loan, Long> {
    @PreAuthorize("hasRole('USER')")
    List<Loan> findByCustomerCustomerIdOrderByStartDtDesc(long customerId);
}
