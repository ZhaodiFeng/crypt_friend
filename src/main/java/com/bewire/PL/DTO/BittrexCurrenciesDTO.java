package com.bewire.PL.DTO;

import java.util.List;

public class BittrexCurrenciesDTO {
    private boolean success;
    private String message;
    private List<BittrexCurrenciesCurrencyDTO> result;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<BittrexCurrenciesCurrencyDTO> getResult() {
        return result;
    }

    public void setResult(List<BittrexCurrenciesCurrencyDTO> result) {
        this.result = result;
    }
}
