package com.github.sharifulineugene;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class TaskTest {
    @Test
    public void jsonHaveDublicates() {
        URL url = Thread.currentThread().getContextClassLoader().getResource("testJsonHaveDublicates.json");
        String path = new File(url.getPath()).getAbsolutePath();
        JsonFacturaParser parser = new JsonFacturaParser(path);
        Set<Factura> expected = new HashSet<>();
        expected.add(new Factura("account1",
                new BigDecimal("1.29324")));
        List<Factura> factures = parser.getListFactures();
        Set<Factura> actual = factures.stream()
                .filter(a -> Collections.frequency(factures,a)>1)
                .collect(Collectors.toSet());
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void jsonDoesNotHaveDublicates() {
        URL url = Thread.currentThread().getContextClassLoader().getResource("testJsonDoesNotHaveDublicates.json");
        String path = new File(url.getPath()).getAbsolutePath();
        JsonFacturaParser parser = new JsonFacturaParser(path);
        Set<Factura> expected = new HashSet<>();
        BigDecimal exp = new BigDecimal("1.29324");
        exp = exp.add(new BigDecimal("131.132"));
        exp = exp.add(new BigDecimal("213131.291"));
        System.out.println(exp);
        List<Factura> factures = parser.getListFactures();
        BigDecimal act = factures.stream().map(Factura::getBalance)
                .reduce(BigDecimal.ZERO,BigDecimal::add);
        Set<Factura> actual = factures.stream()
                .filter(a -> Collections.frequency(factures,a)>1)
                .collect(Collectors.toSet());
        Assertions.assertEquals(expected, actual);
        Assertions.assertEquals(exp,act);
    }
}
