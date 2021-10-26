package com.github.sharifulin.main;

import com.github.sharifulin.entity.Person;
import com.github.sharifulin.utils.PersonScanner;

import java.util.Comparator;
import java.util.List;

public class Main3 {
    public static void main(String[] args) {
        try(PersonScanner personScanner = new PersonScanner(System.in)) {
            List<Person> persons = personScanner.getPersons();
            Comparator<Person> comparator = (Person first, Person second) -> {
                return !first.getLastName().equals(second.getLastName())
                        ? first.getLastName().compareTo(second.getLastName())
                        : first.getFirstName().compareTo(second.getFirstName());
            };
            persons.stream().sorted(comparator).forEach(System.out::println);
        }
    }

}
