package io.bayrktlihn.springsecuritytutorial.controller;

import io.bayrktlihn.springsecuritytutorial.model.Contact;
import io.bayrktlihn.springsecuritytutorial.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Random;

@RestController
@RequiredArgsConstructor
public class ContactController {


    private final ContactRepository contactRepository;

    @PostMapping("contact")
    @PreFilter("filterObject.contactName == 'Test'")
    public Contact saveContactInquiryDetails(@RequestBody Contact contact) {
        contact.setContactId(getServiceReqNumber());
        contact.setCreateDt(new Date());
        return contactRepository.save(contact);
    }

    private String getServiceReqNumber() {
        Random random = new Random();
        return "SR" + random.nextInt(999999999 - 9999) + 9999;
    }
}
