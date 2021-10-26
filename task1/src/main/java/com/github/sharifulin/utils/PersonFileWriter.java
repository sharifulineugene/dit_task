package com.github.sharifulin.utils;

import com.github.sharifulin.entity.Person;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;

public class PersonFileWriter implements Closeable {
    private FileWriter fw;

    public PersonFileWriter(String path) {
        try {
            fw = new FileWriter(path, Charset.defaultCharset());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void write(Person person) {
        try {
            fw.write(person.toString()+'\n');
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void close() {
        if(fw != null) {
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
