package com.github.sharifulin.main;

import com.github.sharifulin.entity.Person;
import com.github.sharifulin.utils.PersonScanner;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        PersonScanner personScanner = new PersonScanner(sc);

        int code = 0;
        while(code != 3) {
            System.out.println("Menu:\n1.Add\n2.Show\n3.Exit");
            code = sc.nextInt();
            switch(code) {
                case 1: {
                    persons.add(personScanner.getPerson());
                    break;
                }
                case 2: {
                    persons.stream().forEach(System.out::println);
                    break;
                }
                case 3: {
                    break;
                }
                default: {
                    System.out.println("Input is not correct, try again");
                }
            }
        }
        if(personScanner != null)
            personScanner.close();
    }
}
