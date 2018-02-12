package com.bewire.Models;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Currency {
    private int id;
    private String name;
    private String symbol;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "Name", nullable = false, length = 255,unique = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "Symbol", nullable = true, length = 255)
    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Currency currency = (Currency) o;
        return id == currency.id &&
                Objects.equals(name, currency.name) &&
                Objects.equals(symbol, currency.symbol);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, symbol);
    }
}
