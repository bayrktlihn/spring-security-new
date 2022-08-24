package io.bayrktlihn.springsecuritytutorial.repository;

import io.bayrktlihn.springsecuritytutorial.model.AccountTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountTransactionRepository extends JpaRepository<AccountTransaction, Long> {
    List<AccountTransaction> findByCustomerCustomerIdOrderByTransactionDtDesc(Long customerId);
}
