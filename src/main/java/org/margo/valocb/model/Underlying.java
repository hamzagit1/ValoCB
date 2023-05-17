package org.margo.valocb.model;

import lombok.Data;

import java.util.HashMap;

import static org.margo.valocb.controller.CSVParser.parseForex;

@Data
public class Underlying implements Priceable {
    private String id;
    private String currency;
    private float rawPrice;
    private Float underlyingPrice = 0.0f;

    public Underlying(String id, String currency, float rawPrice){
        this.id = id;
        this.currency = currency;
        this.rawPrice = rawPrice;
    }

    public Float getPrice(){
        if (this.underlyingPrice == 0.0f){
            this.price();
        }
        return this.underlyingPrice;
    }

    private void price(){
        HashMap<String, Float> FOREX = parseForex("Forex.csv");
        this.underlyingPrice = this.rawPrice * FOREX.get(this.currency);
    }

}