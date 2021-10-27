package com.github.sharifulineugene;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class CustomArrayIteratorTest {
    @Test
    public void shouldReturnList() {
        String[][] arr = new String[][]{{"1","2","3"},{"4","5","6"},{"String", "fedfe", "vfdvdvdvd"}};
        List<String> expected = new ArrayList<>(Arrays.asList(new String[]{"1","2","3", "4","5","6", "String", "fedfe", "vfdvdvdvd"}));
        List<String> actual = new ArrayList<>();
        CustomArrayIterator<String> it = new CustomArrayIterator<>(arr);
        while(it.hasNext()) {
            actual.add(it.next());
        }
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void hasNext() {
        String[][] arr = new String[][]{{"1","2","3"},{"4","5","6"},{"String", "fedfe", "vfdvdvdvd"}};
        CustomArrayIterator<String> it = new CustomArrayIterator<>(arr);
        while(it.hasNext()) {
            it.next();
        }
        Assertions.assertFalse(it.hasNext());
    }

    @Test
    public void next() {
        String[][] arr = new String[][]{{"1","2","3"},{"4","5","6"},{"String", "fedfe", "vfdvdvdvd"}};
        CustomArrayIterator<String> it = new CustomArrayIterator<>(arr);
        for(int i = 0; i < 4; ++i) {
            it.next();
        }
        Assertions.assertEquals("5",it.next());
    }

    @Test
    public void mustThrowNoSuchElementException() {
        String[][] arr = new String[][]{{"1","2","3"},{"4","5","6"},{"String", "fedfe", "vfdvdvdvd"}};
        CustomArrayIterator<String> it = new CustomArrayIterator<>(arr);
        while(it.hasNext()) {
            it.next();
        }
        Assertions.assertThrows(NoSuchElementException.class, it::next);
    }
}
