package com.bewire.BLL;

import com.bewire.PL.DTO.BittrexTickeResultDTO;

import java.io.IOException;
import java.util.Currency;
import java.util.List;

public interface IMarketApiBLL {
    void UpdateCurrenciesList() throws IOException;

    void UpdateMarketsList() throws IOException;

    BittrexTickeResultDTO getMarketTicker(int marketId) throws IOException;
}
