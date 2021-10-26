package com.github.sharifulin.main;

import com.github.sharifulin.entity.Person;
import com.github.sharifulin.utils.PersonScanner;

public class Main1 {
    public static void main(String[] args) {
        try(PersonScanner personScanner = new PersonScanner(System.in)) {
            Person person = personScanner.getPerson();
            System.out.println(person);
        }
    }
}
