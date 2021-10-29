package com.github.sharifulineugene;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FacturaMapper {
    private static final Pattern pattern = Pattern.compile("\\s*\\{?\\s*\"account\"\\s*:\\s*\"(.*)\"\\s*,\\s*\"balance\"\\s*:\\s*\"(\\d*\\.\\d*)\"\\s*}?\\s*");
    public static String facturaToString(Factura factura) {
        return "{ \"account\": \"" + factura.getAccount() + "\", \"balance\": \"" + factura.getBalance() + "\" }";
    }

    public static Factura stringToFactura(String factura) {
        Matcher matcher = pattern.matcher(factura);
        if(!matcher.matches())
            return null;
        return new Factura(matcher.group(1), new BigDecimal(matcher.group(2)));
    }
}
