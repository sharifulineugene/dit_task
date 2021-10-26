package com.github.sharifulin.utils;

import com.github.sharifulin.entity.Person;

import java.io.Closeable;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PersonScanner implements Closeable {
    private Scanner scanner;

    public PersonScanner(){}
    public PersonScanner(InputStream stream) {
        scanner = new Scanner(stream);
    }

    public PersonScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public void setInputStream(InputStream stream) {
        scanner = new Scanner(stream);
    }

    public Person getPerson() {
        System.out.println("Insert first_name: ");
        String firstName = scanner.nextLine();
        System.out.println("Insert last_name: ");
        String lastName = scanner.nextLine();
        return Person.builder().fistName(firstName).lastName(lastName).build();
    }

    public List<Person> getPersons() {
        List<Person> persons = new ArrayList<>();
        System.out.println("Do you want start scanning? (y/n)");
        String message=scanner.nextLine();
        if(message.equals("y")) {
            while (!message.equals("quit")) {
                persons.add(getPerson());
                System.out.println("If you want stop scanning write : quit\nElse write any another word or symbol and press enter...");
                message = scanner.nextLine();
            }
        }
        return persons;
    }


    @Override
    public void close(){
        if(scanner != null)
            scanner.close();
    }
}
