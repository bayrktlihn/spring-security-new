package io.bayrktlihn.springsecuritytutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EntityScan("io.bayrktlihn.springsecuritytutorial.model")
@EnableJpaRepositories("io.bayrktlihn.springsecuritytutorial.repository")
@EnableWebSecurity(debug = true)
public class SpringSecurityTutorialApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityTutorialApplication.class, args);
    }

}
