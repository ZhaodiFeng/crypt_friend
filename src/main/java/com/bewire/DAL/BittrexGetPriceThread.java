package com.bewire.DAL;

import com.bewire.BLL.CustomHttpClient;
import com.bewire.Models.Market;
import com.bewire.PL.DTO.BittrexTickerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Scope("prototype")
public class BittrexGetPriceThread extends Thread{
    @Value("${bittrex.api.gettticker.url}")
    String bittrexTickerUrl;
    @Autowired
    CustomHttpClient customHttpClient;
    @Autowired
    CurrentPrice currentPrice;
    Market market;

    public Market getMarket() {
        return market;
    }

    public void setMarket(Market market) {
        this.market = market;
    }

    @Override
    public void run() {
        BittrexTickerDTO bittrexTickerDTO = null;
        try {
            bittrexTickerDTO = customHttpClient.getObjectFromHttpGet(bittrexTickerUrl + "?market=" + getMarket().getName(), BittrexTickerDTO.class);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            currentPrice.getCurrenctPrice().put(market.getId(), bittrexTickerDTO.getResult());
            System.out.println(market.getId() + ":" + market.getName());
        }
    }
}
