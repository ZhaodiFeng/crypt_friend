package com.bewire.BLL;

import com.bewire.DAL.ExchangeDAO;
import com.bewire.Models.Exchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExchangeBLL implements IExchangeBLL {
    @Autowired
    ExchangeDAO exchangeDAO;

    @Override
    public List<Exchange> getAllExchanges() {
        return exchangeDAO.getAllByIdIsNotNull();
    }
}
