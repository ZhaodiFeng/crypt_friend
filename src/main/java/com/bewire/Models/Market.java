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
    private Integer apiAdres;

    @Id
    @Column(name = "Id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Name", nullable = false, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "ApiAdres", nullable = true)
    public Integer getApiAdres() {
        return apiAdres;
    }

    public void setApiAdres(Integer apiAdres) {
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
