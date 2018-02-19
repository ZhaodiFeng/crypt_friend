package com.bewire.Models;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Wallet {
    private int id;
    private String userId;
    private String name;
    private String url;
    private int exchangeId;


    public Wallet() {
        setName("Default portfolio");
    }

    public Wallet(String userId,int exchangeId){
        this();
        setUserId(userId);
        setExchangeId(exchangeId);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Column(name = "User_Id", nullable = false, length = 21)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }


    @Column(name = "Name", nullable = false, length = 255)
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


    @Column(name = "Exchange_Id", nullable = false)
    public int getExchangeId() {
        return exchangeId;
    }

    public void setExchangeId(int exchangeId) {
        this.exchangeId = exchangeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wallet wallet = (Wallet) o;
        return id == wallet.id &&
                exchangeId == wallet.exchangeId &&
                Objects.equals(userId, wallet.userId) &&
                Objects.equals(name, wallet.name) &&
                Objects.equals(url, wallet.url);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, userId, name, url, exchangeId);
    }
}
