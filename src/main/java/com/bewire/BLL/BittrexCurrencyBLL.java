package com.bewire.BLL;

import com.bewire.DAL.CurrencyDAO;
import com.bewire.PL.DTO.BittrexCurrenciesCurrencyDTO;
import com.bewire.PL.DTO.BittrexCurrenciesDTO;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.Currency;
import java.util.List;

@Service
public class BittrexCurrencyBLL implements IMarketApiBLL {
    @Value( "${bittrex.api.getcurrencies.url}" )
    private String bittrexUrl;
    @Autowired
    private CurrencyDAO currencyDAO;
    @Autowired
    private CustomHttpClient customHttpClient;

    @Transactional
    public void UpdateCurrenciesList() throws IOException {
       BittrexCurrenciesDTO bittrexCurrenciesDTO=(BittrexCurrenciesDTO) customHttpClient.getObjectFromHttpGet(bittrexUrl,BittrexCurrenciesDTO.class);
       List<BittrexCurrenciesCurrencyDTO> currencies=bittrexCurrenciesDTO.getResult();
       for (BittrexCurrenciesCurrencyDTO c :
              currencies) {
            com.bewire.Models.Currency currency = currencyDAO.findCurrencyByName(c.getCurrencyLong());
            if (currency == null) {
                currency = new com.bewire.Models.Currency();
            }
            currency.setName(c.getCurrencyLong());
            currency.setSymbol(c.getCurrency());
            currencyDAO.save(currency);
        }
    }
}
