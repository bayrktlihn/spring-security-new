package io.bayrktlihn.springsecuritytutorial.config;

import io.bayrktlihn.springsecuritytutorial.model.Customer;
import io.bayrktlihn.springsecuritytutorial.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class BayrktlihnAuthenticationProvider implements AuthenticationProvider {


    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        Customer customer = customerRepository.findByEmail(username).orElseThrow(() -> new BadCredentialsException("No user registered with this details!"));

        if (passwordEncoder.matches(password, customer.getPwd())) {

            List<SimpleGrantedAuthority> authorities = customer.getAuthorities()
                    .stream()
                    .map(authority -> new SimpleGrantedAuthority(authority.getName()))
                    .collect(Collectors.toList());
//            String role = customer.getRole().toString();
//            SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(role);
            return new UsernamePasswordAuthenticationToken(username, password, authorities);
        } else {
            throw new BadCredentialsException("Invalid password!");
        }

    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
