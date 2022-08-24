package io.bayrktlihn.springsecuritytutorial.controller;

import io.bayrktlihn.springsecuritytutorial.model.Card;
import io.bayrktlihn.springsecuritytutorial.model.Customer;
import io.bayrktlihn.springsecuritytutorial.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CardController {

    private final CardRepository cardRepository;

    @PostMapping("myCards")
    public List<Card> getCardDetails(@RequestBody Customer customer) {
        return cardRepository.findByCustomerCustomerId(customer.getCustomerId());
    }

}
