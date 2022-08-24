package io.bayrktlihn.springsecuritytutorial.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "contact")
@Getter
@Setter
public class Contact {

    @Id
    @Column(name = "contact_id", length = 50)
    private String contactId;

    @Column(name = "contact_name", length = 50)
    private String contactName;

    @Column(name = "contact_email", length = 100)
    private String contactEmail;


    @Column(name = "subject", length = 500)
    private String subject;


    @Column(name = "message", length = 2000)
    private String message;

    @Column(name = "create_dt")
    private Date createDt;
}
