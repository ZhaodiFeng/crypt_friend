package com.bewire.Models;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Exchange {
    private int id;
    private String name;
    private String url;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Column(name = "Name", nullable = false, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Column(name = "Url", nullable = true, length = 255)
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Exchange exchange = (Exchange) o;
        return id == exchange.id &&
                Objects.equals(name, exchange.name) &&
                Objects.equals(url, exchange.url);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, url);
    }
}
