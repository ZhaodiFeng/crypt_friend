package com.bewire.Models;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Market {
    private int id;
    private String name;
    private String apiAdres;

    @Id
    @Column(name = "Id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "ApiAdres")
    public String getApiAdres() {
        return apiAdres;
    }

    public void setApiAdres(String apiAdres) {
        this.apiAdres = apiAdres;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Market market = (Market) o;
        return id == market.id &&
                Objects.equals(name, market.name) &&
                Objects.equals(apiAdres, market.apiAdres);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, apiAdres);
    }
}
