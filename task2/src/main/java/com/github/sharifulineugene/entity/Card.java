package com.github.sharifulineugene.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "card")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public final class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "exp_date")
    private String expDate;

    @ManyToOne(cascade={CascadeType.MERGE
            ,CascadeType.PERSIST
            ,CascadeType.DETACH
            ,CascadeType.REFRESH})
    @JoinColumn(name="account_id")
    @JsonIgnore
    private Account account;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    public Card(int id, String cardNumber, String expDate, Account account, Status status) {
        this.id = id;
        this.cardNumber = cardNumber;
        this.expDate = expDate;
        this.account = account;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", cardNumber='" + cardNumber + '\'' +
                ", expDate='" + expDate + '\'' +
                ", account=" + account +
                ", status=" + status +
                '}';
    }

    public enum Status {
        ACTIVE, NEW, BLOCKED;
    }
}
