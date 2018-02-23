package com.bewire.DAL;

import com.bewire.PL.DTO.BittrexTickeResultDTO;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class CurrentPrice {
    private static Map<Integer, BittrexTickeResultDTO> currenctPrice=new HashMap<Integer, BittrexTickeResultDTO>();

    public Map<Integer, BittrexTickeResultDTO> getCurrenctPrice() {
        return currenctPrice;
    }

    public void setCurrenctPrice(Map<Integer, BittrexTickeResultDTO> currenctPrice) {
        CurrentPrice.currenctPrice = currenctPrice;
    }

}
