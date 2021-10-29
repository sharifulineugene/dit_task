package com.github.sharifulineugene;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class FacturaMapperTest {
    @Test
    public void shouldReturnFactura() {
        String facturaString = "\"account\": \"account1\",\n" +
                "  \"balance\": \"1.29324\"\n";
        Factura expected = new Factura("account1", new BigDecimal("1.29324"));
        Factura actual = FacturaMapper.stringToFactura(facturaString);
        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void shouldReturnString() {
        Factura factura = new Factura("test2", new BigDecimal("12345678.90"));
        String expected = "{ \"account\": \"test2\", \"balance\": \"12345678.90\" }";
        String actual = FacturaMapper.facturaToString(factura);
        Assertions.assertEquals(expected,actual);
    }
}
