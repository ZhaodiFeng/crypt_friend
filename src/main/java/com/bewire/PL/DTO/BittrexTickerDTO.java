package com.bewire.PL.DTO;

public class BittrexTickerDTO {
    private String success;
    private String message;
    private BittrexTickeResultDTO result;

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public BittrexTickeResultDTO getResult() {
        return result;
    }

    public void setResult(BittrexTickeResultDTO result) {
        this.result = result;
    }
}
