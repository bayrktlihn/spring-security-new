package io.bayrktlihn.springsecuritytutorial.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "account_transaction")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountTransaction {

    @Id
    @Column(name = "transaction_id", length = 200)
    private String transactionId;

    @ManyToOne
    @JoinColumn(name = "account_number")
    private Account account;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(name = "transaction_dt")
    private Date transactionDt;

    @Column(name = "transaction_summary", length = 200)
    private String transactionSummary;

    @Enumerated(EnumType.STRING)
    @Column(name = "transaction_type", length = 100)
    private TransactionType transactionType;

    @Column(name = "transaction_amt")
    private long transactionAmt;

    @Column(name = "closing_balance")
    private long closingBalance;

    @Column(name = "create_dt")
    private Date createDt;


}
