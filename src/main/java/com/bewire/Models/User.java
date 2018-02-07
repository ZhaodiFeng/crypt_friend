package com.bewire.Models;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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

    @Basic
    @Column(name = "Name", nullable = false, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "MailAdres", nullable = false, length = 50)
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
