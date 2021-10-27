package com.github.sharifulineugene;

import java.util.*;
import java.util.stream.Collectors;

public class Dublicates {
    public static <T> Set<T> firstDublicateMethod(Collection<T> first, Collection<T> second) {
        Set<T> setFirst = new HashSet<>(first);
        Set<T> returnSet = new HashSet<>();
        for(T t : second) {
            if(!setFirst.add(t)) {
                returnSet.add(t);
            }
        }
        return returnSet;
    }

    public static <T> Set<T> secondDublicateMethod(Collection<T> first, Collection<T> second) {
        List<T> temp = new ArrayList<>(new HashSet<T>(first));
        temp.addAll(second);
        return temp.stream().filter(t -> Collections.frequency(temp,t) > 1).collect(Collectors.toSet());
    }

    public static <T> Set<T> thirdDublicateMethod(Collection<T> first, Collection<T> second) {
        Set<T> temp = new HashSet<T>(first);
        temp.retainAll(second);
        return temp;
    }
}
