package com.bewire.BLL;

import java.io.IOException;
import java.util.Currency;
import java.util.List;

public interface IMarketApiBLL {
    void UpdateCurrenciesList() throws IOException;

    void UpdateMarketsList() throws IOException;
}
