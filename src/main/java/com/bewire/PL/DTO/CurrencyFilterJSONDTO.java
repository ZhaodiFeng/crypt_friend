package com.bewire.PL.DTO;

import com.bewire.Models.Currency;

import java.util.List;

public class CurrencyFilterJSONDTO {
    private String query;
    private List<Currency> suggestions;

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public List<Currency> getSuggestions() {
        return suggestions;
    }

    public void setSuggestions(List<Currency> suggestions) {
        this.suggestions = suggestions;
    }
}
