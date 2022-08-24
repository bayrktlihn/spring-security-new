package io.bayrktlihn.springsecuritytutorial.repository;

import io.bayrktlihn.springsecuritytutorial.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardRepository extends JpaRepository<Card, Long> {
    List<Card> findByCustomerCustomerId(Long customerId);
}
