package io.bayrktlihn.springsecuritytutorial.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "loan")
@Getter
@Setter
@NoArgsConstructor
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "loan_number")
    private long loanNumber;


    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;


    @Column(name = "start_dt")
    @Temporal(TemporalType.DATE)
    private Date startDt;

    @Enumerated(EnumType.STRING)
    @Column(name = "loan_type", length = 100)
    private LoanType loanType;

    @Column(name = "total_loan")
    private long totalLoan;

    @Column(name = "amount_paid")
    private long amountPaid;

    @Column(name = "outstanding_amount")
    private long outstandingAmount;

    @Column(name = "create_dt")
    @Temporal(TemporalType.DATE)
    private Date createDt;


    public Loan(Customer customer, Date startDt, LoanType loanType, long totalLoan, long amountPaid, long outstandingAmount, Date createDt) {
        this.customer = customer;
        this.startDt = startDt;
        this.loanType = loanType;
        this.totalLoan = totalLoan;
        this.amountPaid = amountPaid;
        this.outstandingAmount = outstandingAmount;
        this.createDt = createDt;
    }
}
