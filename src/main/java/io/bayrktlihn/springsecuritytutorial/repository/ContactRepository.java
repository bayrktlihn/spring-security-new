package io.bayrktlihn.springsecuritytutorial.repository;

import io.bayrktlihn.springsecuritytutorial.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}
