package io.bayrktlihn.springsecuritytutorial.filter;

import lombok.extern.java.Log;

import javax.servlet.*;
import java.io.IOException;

@Log
public class AuthoritiesLoggingAtFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("Authentication Validation is in progress");
        chain.doFilter(request, response);
    }
}
