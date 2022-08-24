package io.bayrktlihn.springsecuritytutorial.filter;

import lombok.extern.java.Log;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.*;
import java.io.IOException;

@Log
public class AuthoritiesLoggingAfterFilter implements Filter {


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null) {
            String message = String.format("User %s is successfully authenticated and has the authorities %s", authentication.getName(), authentication.getAuthorities().toString());
            log.info(message);
        }

        filterChain.doFilter(request, response);
    }
}
