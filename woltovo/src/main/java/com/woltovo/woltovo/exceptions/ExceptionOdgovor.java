package com.woltovo.woltovo.exceptions;

import lombok.Builder;

@Builder
public class ExceptionOdgovor {
    private String greska;
    private String httpKod;

    public ExceptionOdgovor(String greska, String httpKod) {
        this.greska = greska;
        this.httpKod = httpKod;
    }

    public String getgreska() {
        return this.greska;
    }

    public void setgreska(String greska) {
        this.greska = greska;
    }

    public String getHttpKod() {
        return this.httpKod;
    }

    public void setHttpKod(String httpKod) {
        this.httpKod = httpKod;
    }        
}
