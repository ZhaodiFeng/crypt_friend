package com.bewire.BLL;

import com.bewire.DAL.*;
import com.bewire.Models.Currency;
import com.bewire.Models.CurrencyMarketPrice;
import com.bewire.Models.Exchange;
import com.bewire.Models.Market;
import com.bewire.PL.DTO.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BittrexBLL implements IMarketApiBLL {
    @Value( "${bittrex.api.getcurrencies.url}" )
    private String bittrexUrl;
    @Value("${bittrex.api.getmarkets.url}")
    private String bittrexMarketsUrl;
    @Value("${bittrex.api.gettticker.url}")
    private String bittrexTickerUrl;
    @Autowired
    private CurrencyDAO currencyDAO;
    @Autowired
    private MarketDAO marketDAO;
    @Autowired
    private ExchangeDAO exchangeDAO;
    @Autowired
    private CustomHttpClient customHttpClient;
    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private CurrentPrice currentPrice;
    @Autowired
    private TaskExecutor taskExecutor;

    @Transactional
    public void UpdateCurrenciesList() throws IOException {
       BittrexCurrenciesDTO bittrexCurrenciesDTO= customHttpClient.getObjectFromHttpGet(bittrexUrl,BittrexCurrenciesDTO.class);
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
    @Transactional
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

    @Override
    public BittrexTickeResultDTO getMarketTicker(int marketId) throws IOException {
     return currentPrice.getCurrenctPrice().get(marketId);
    }

    @Scheduled(cron = "${bittex.api.ticker.cron}")
    public void  UpdateCurrentPrice(){
        System.out.println("Loop:");
        for (Market m:
             marketDAO.findAll()) {
                BittrexGetPriceThread thread= (BittrexGetPriceThread) applicationContext.getBean("bittrexGetPriceThread");
                thread.setMarket(m);
                taskExecutor.execute(thread);
        }
    }

    public  Map<Integer, BittrexTickeResultDTO> getCurrentMarketsPrice(){
        return currentPrice.getCurrenctPrice();
    }
}
