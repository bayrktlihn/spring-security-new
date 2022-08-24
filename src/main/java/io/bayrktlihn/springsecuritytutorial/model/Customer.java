package io.bayrktlihn.springsecuritytutorial.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "customer")
@Getter
@Setter
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customer_id")
    private long customerId;

    @Column(name = "name", length = 100)
    private String name;

    @Column(length = 100)
    private String email;

    @Column(name = "mobile_number", length = 20)
    private String mobileNumber;

    @Column(name = "pwd", length = 512)
    private String pwd;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", length = 100)
    private Role role;

    @Column(name = "create_dt")
    private Date createDt;

    @OneToMany(mappedBy = "customer")
    @JsonIgnore
    private Set<Account> accounts;

    @OneToMany(mappedBy = "customer")
    @JsonIgnore
    private Set<AccountTransaction> accountTransactions;

    @OneToMany(mappedBy = "customer")
    @JsonIgnore
    private Set<Loan> loans;

    @OneToMany(mappedBy = "customer")
    @JsonIgnore
    private Set<Card> cards;

    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Authority> authorities;
}
