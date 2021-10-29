package com.github.sharifulineugene;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class JsonFacturaParserTest {
    @Test
    public void listJsonFactures() {
        URL url = Thread.currentThread().getContextClassLoader().getResource("listJsonFacturesTest.json");
        String path = new File(url.getPath()).getAbsolutePath();
        JsonFacturaParser parser = new JsonFacturaParser(path);
        List<String> actual = null;
        List<String> expected = new ArrayList<>(
                Arrays.asList("{      \"account\": \"account1\",      \"balance\": \"1.29324\"    }"
                ,"{      \"account\": \"account2\",      \"balance\": \"131.132\"    }"
                ,"{      \"account\": \"account3\",      \"balance\": \"21231.032\"    }")
        );
        try {
            Method method = JsonFacturaParser.class.getDeclaredMethod("listJsonFactures");
            method.setAccessible(true);
            actual = (List<String>)method.invoke(parser);
            actual.stream().forEach(System.out::println);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
        Assertions.assertEquals(expected, actual);
    }


}
