package io.bayrktlihn.springsecuritytutorial.config;

import io.bayrktlihn.springsecuritytutorial.model.Customer;
import io.bayrktlihn.springsecuritytutorial.model.SecurityCustomer;
import io.bayrktlihn.springsecuritytutorial.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class BayrktlihnUserDetails implements UserDetailsService {

    private final CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer customer = customerRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("User details not found for the user : " + username));
        return new SecurityCustomer(customer);
    }
}
