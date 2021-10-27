package com.github.sharifulineugene;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class DublicatesTest {
    @Test
    public void firstDublicateMethod() {
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1,2,3,4,4,5));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(1,6,4,3,11,9));
        Set<Integer> expected = new HashSet<>(Arrays.asList(1,3,4));
        Set<Integer> actual = Dublicates.firstDublicateMethod(list1,list2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void secondDublicateMethod() {
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1,2,3,4,4,5));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(1,6,4,3,11,9));
        Set<Integer> expected = new HashSet<>(Arrays.asList(1,3,4));
        Set<Integer> actual = Dublicates.secondDublicateMethod(list1,list2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void thirdDublicateMethod() {
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1,2,3,4,4,5));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(1,6,4,3,11,9));
        Set<Integer> expected = new HashSet<>(Arrays.asList(1,3,4));
        Set<Integer> actual = Dublicates.thirdDublicateMethod(list1,list2);
        Assertions.assertEquals(expected, actual);
    }
}
