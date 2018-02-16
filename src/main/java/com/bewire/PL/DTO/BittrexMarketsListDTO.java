package com.bewire.PL.DTO;

import java.util.List;

public class BittrexMarketsListDTO {
    private boolean success;
    private String message;
    private List<BittrexMarketDTO> result;

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

    public List<BittrexMarketDTO> getResult() {
        return result;
    }

    public void setResult(List<BittrexMarketDTO> result) {
        this.result = result;
    }
}
