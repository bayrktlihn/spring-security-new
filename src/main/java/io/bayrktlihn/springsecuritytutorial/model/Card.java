package io.bayrktlihn.springsecuritytutorial.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "card")
@Getter
@Setter
@NoArgsConstructor
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "card_id")
    private long cardId;

    @Column(name = "card_number")
    private String cardNumber;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;


    @Enumerated(EnumType.STRING)
    @Column(name = "card_type")
    private CardType cardType;

    @Column(name = "total_limit")
    private long totalLimit;

    @Column(name = "amount_used")
    private long amountUsed;

    @Column(name = "available_amount")
    private long availableAmount;

    @Column(name = "create_dt")
    private Date createDt;

    public Card(String cardNumber, Customer customer, CardType cardType, long totalLimit, long amountUsed, long availableAmount, Date createDt) {
        this.cardNumber = cardNumber;
        this.customer = customer;
        this.cardType = cardType;
        this.totalLimit = totalLimit;
        this.amountUsed = amountUsed;
        this.availableAmount = availableAmount;
        this.createDt = createDt;
    }
}
