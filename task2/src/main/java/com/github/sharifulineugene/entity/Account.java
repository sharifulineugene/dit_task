package com.github.sharifulineugene.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="account")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class Account {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="number")
    private String number;

    public Account(int id, String number, Person person, Long balance) {
        this.id = id;
        this.number = number;
        this.person = person;
        this.balance = balance;
    }

    @ManyToOne(cascade = {CascadeType.PERSIST
            , CascadeType.MERGE
            , CascadeType.DETACH
            , CascadeType.REFRESH})
    @JoinColumn(name="person_id")
    private Person person;
    @Column(name="balance")
    private Long balance;
    @OneToMany(fetch=FetchType.EAGER,cascade = CascadeType.ALL,mappedBy = "account")
    private List<Card> cards;

    public void addCardToAccount(Card card) {
        if(cards == null)
            cards = new ArrayList<>();
        cards.add(card);
        card.setAccount(this);
    }

}
