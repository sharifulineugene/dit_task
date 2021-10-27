package com.github.sharifulin.utils;

import com.github.sharifulin.entity.Person;

import java.io.*;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class PersonFileReader implements Closeable {
    private static final Pattern pattern = Pattern.compile("\\{ firstName: \"(.*)\", lastName: \"(.*)\" }");
    BufferedReader reader;
    public PersonFileReader(String filePath) {
        try {
            reader = new BufferedReader(new FileReader(filePath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public List<Person> readFile() {
        return reader.lines().map(this::parseString).filter(Objects::nonNull).collect(Collectors.toList());
    }

    private Person parseString(String personStr) {
        Matcher matcher = pattern.matcher(personStr);
        String firstName = null;
        String lastName = null;
        if(matcher.matches()) {
            firstName = matcher.group(1);
            lastName = matcher.group(2);
            return new Person(firstName,lastName);
        }
        return null;
    }

    @Override
    public void close() {
        try {
            if(reader != null)
                reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
