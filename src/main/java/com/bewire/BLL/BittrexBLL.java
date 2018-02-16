package com.bewire.BLL;

import com.bewire.DAL.CurrencyDAO;
import com.bewire.DAL.ExchangeDAO;
import com.bewire.DAL.MarketDAO;
import com.bewire.Models.Currency;
import com.bewire.Models.Exchange;
import com.bewire.Models.Market;
import com.bewire.PL.DTO.BittrexCurrenciesCurrencyDTO;
import com.bewire.PL.DTO.BittrexCurrenciesDTO;
import com.bewire.PL.DTO.BittrexMarketDTO;
import com.bewire.PL.DTO.BittrexMarketsListDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

@Service
public class BittrexBLL implements IMarketApiBLL {
    @Value( "${bittrex.api.getcurrencies.url}" )
    private String bittrexUrl;
    @Value("${bittrex.api.getmarkets.url}")
    private String bittrexMarketsUrl;
    @Autowired
    private CurrencyDAO currencyDAO;
    @Autowired
    private MarketDAO marketDAO;
    @Autowired
    private ExchangeDAO exchangeDAO;
    @Autowired
    private CustomHttpClient customHttpClient;

    @Transactional
    public void UpdateCurrenciesList() throws IOException {
       BittrexCurrenciesDTO bittrexCurrenciesDTO=(BittrexCurrenciesDTO) customHttpClient.getObjectFromHttpGet(bittrexUrl,BittrexCurrenciesDTO.class);
       List<BittrexCurrenciesCurrencyDTO> currencies=bittrexCurrenciesDTO.getResult();
       for (BittrexCurrenciesCurrencyDTO c :
              currencies) {
            Currency currency = currencyDAO.findCurrencyByName(c.getCurrencyLong());
            if (currency == null) {
                currency = new Currency();
            }
            currency.setName(c.getCurrencyLong());
            currency.setSymbol(c.getCurrency());
            currencyDAO.save(currency);
        }
    }

    @Override
    public void UpdateMarketsList() throws IOException {
        BittrexMarketsListDTO bittrexMarketsListDTO=(BittrexMarketsListDTO) customHttpClient.getObjectFromHttpGet(bittrexMarketsUrl,BittrexMarketsListDTO.class);
        List<BittrexMarketDTO> markets=bittrexMarketsListDTO.getResult();
        for (BittrexMarketDTO m:markets){
            Market market=marketDAO.findFirstByName(m.getMarketName());
            if (market==null){
                market=new Market();
            }
            market.setName(m.getMarketName());
            market.setBuyCurrencyId(currencyDAO.findCurrencyBySymbol(m.getMarketCurrency()).getId());
            market.setPayCurrencyId(currencyDAO.findCurrencyBySymbol(m.getBaseCurrency()).getId());
            market.setExchangeId(exchangeDAO.findFirstByName("Bittrex").getId());
            marketDAO.save(market);
        }

    }
}
