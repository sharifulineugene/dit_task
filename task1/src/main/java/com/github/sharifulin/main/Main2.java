package com.github.sharifulin.main;

import com.github.sharifulin.entity.Person;
import com.github.sharifulin.utils.PersonScanner;

import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        try(PersonScanner personScanner = new PersonScanner(System.in)) {
            List<Person> persons = personScanner.getPersons();
            persons.stream().forEach(System.out::println);
        }
    }
}
