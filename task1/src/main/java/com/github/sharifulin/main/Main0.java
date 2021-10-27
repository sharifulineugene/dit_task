package com.github.sharifulin.main;

import com.github.sharifulin.entity.Person;

public class Main0 {
    public static void main(String[] args) {
        Person person = null;
        if(args.length == 2) {
            person = Person.builder().firstName(args[0]).lastName(args[1]).build();
        }
        if(person != null)
            System.out.println(person);
        else
            System.out.println("args is not correct");
    }
}
