package io.bayrktlihn.springsecuritytutorial.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "account")
@Getter
@Setter
public class Account {

    @Id
    @Column(name = "account_number")
    private long accountNumber;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;


    @Column(name = "account_type", length = 100)
    private String accountType;

    @Column(name = "branch_address", length = 200)
    private String branchAddress;

    @Column(name = "create_dt")
    private Date createDt;

    @OneToMany(mappedBy = "account")
    @JsonIgnore
    private Set<AccountTransaction> accountTransactions;
}
