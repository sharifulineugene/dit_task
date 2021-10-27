package com.github.sharifulin.main;

import com.github.sharifulin.entity.Person;
import com.github.sharifulin.utils.PersonFileWriter;
import com.github.sharifulin.utils.PersonScanner;

import java.util.*;

public class Main6 {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        PersonScanner personScanner = new PersonScanner(sc);
        Comparator<Person> comparator = (Person first, Person second) -> !first.getLastName().equals(second.getLastName())
                ? first.getLastName().compareTo(second.getLastName())
                : first.getFirstName().compareTo(second.getFirstName());


        int code = 0;
        while(code != 4) {
            System.out.println("Menu:\n1.Add\n2.Show\n3.Show sorted unique\n4.Save to file\n5.Exit");
            try{
                code = Integer.parseInt(sc.nextLine());
            } catch(Exception ex) {
                code = 0;
            }
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
                    HashSet<String> set = new HashSet<>();
                    persons.stream().sorted(comparator).filter(p->
                    {
                        if(!set.contains(p.getLastName())) {
                            set.add(p.getLastName());
                            return true;
                        } else
                            return false;
                    }
                    ).forEach(System.out::println);
                    break;

                }
                case 4: {
                    System.out.println("Specify the full path to the file to write.\n!!!Warning!!! The file will be overwritten!");
                    String path = sc.nextLine();
                    try(PersonFileWriter pfw = new PersonFileWriter(path)) {
                        persons.stream().forEach(pfw::write);
                    }
                    break;
                }
                case 5: {
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
