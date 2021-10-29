package com.github.sharifulineugene;

import java.math.BigDecimal;
import java.util.Objects;

public class Factura {
    private String account;
    private BigDecimal balance;
    public Factura(){}
    public Factura(String account, BigDecimal balance) {
        this.account = account;
        this.balance = balance;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "{ \"account\": \"" + this.getAccount() + "\", \"balance\": \"" + this.getBalance() + "\" }";

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Factura factura = (Factura) o;
        return Objects.equals(account, factura.account) && Objects.equals(balance, factura.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(account, balance);
    }

}
