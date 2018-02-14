package com.bewire.Models;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class User {
    private String id;
    private String name;
    private String mailAdres;

    @Id
    @Column(name = "Id", nullable = false, length = 21)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    @Column(name = "Name", nullable = false, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Column(name = "Mail_Adres", nullable = false, length = 255)
    public String getMailAdres() {
        return mailAdres;
    }

    public void setMailAdres(String mailAdres) {
        this.mailAdres = mailAdres;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(name, user.name) &&
                Objects.equals(mailAdres, user.mailAdres);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, mailAdres);
    }
}
