package com.github.sharifulineugene.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="person")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class Person {
    public Person(int id, String name, String surname, String date_of_birth) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.date_of_birth = date_of_birth;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="surname")
    private String surname;

    @Column(name="date_of_birth")
    private String date_of_birth;

    @OneToMany(mappedBy = "person",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Account> accounts;

    @Override
    public String toString() {
        return name +
                " " + surname + " " + date_of_birth ;
    }

    public List<Account> getAccounts() {
        return accounts;
    }
}
