package io.bayrktlihn.springsecuritytutorial.repository;

import io.bayrktlihn.springsecuritytutorial.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByCustomerCustomerId(long customerId);
}
