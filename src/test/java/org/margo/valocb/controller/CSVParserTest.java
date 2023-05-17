package org.margo.valocb.controller;

import org.junit.jupiter.api.Test;
import org.margo.valocb.model.Client;
import org.margo.valocb.model.Portfolio;

import java.util.HashMap;
import java.util.Map;

import static fixtures.ClientFixtures.*;
import static fixtures.PortfolioFixtures.PTF1;
import static fixtures.PortfolioFixtures.PTF2;
import static org.junit.jupiter.api.Assertions.*;
import static org.margo.valocb.controller.CSVParser.*;

class CSVParserTest {

    @Test
    void parseForexTest() {
        HashMap<String, Float> forexHashMap = parseForex("ForexSample.csv");

        assertEquals(forexHashMap.size(), 6);
        assertEquals(forexHashMap.get("USD"), 0.5f);
        assertEquals(forexHashMap.get("CHF"), 4);
        assertEquals(forexHashMap.get("TND"), 0.1f);
        assertEquals(forexHashMap.get("GPB"), 8);
        assertEquals(forexHashMap.get("JPY"), 2);
        assertEquals(forexHashMap.get("EUR"), 1);
    }

    @Test
    void parseForexTestEmptyFile() {
        HashMap<String, Float> forexHashMap = parseForex("ForexSampleEmpty.csv");

        assertEquals(forexHashMap.toString(), "{EUR=1.0}");
    }


    @Test
    void parsePricesTest() {
        HashMap<String, Portfolio> portfoliosHashMap = parsePrices("PricesSample.csv");

        assertEquals(portfoliosHashMap.size(), 2);
        assertEquals(portfoliosHashMap.get("PTF1"), PTF1);
        assertEquals(portfoliosHashMap.get("PTF2"), PTF2);
    }

    @Test
    void parseProductTest() {
        HashMap<String, Portfolio> portfoliosHashMap = parsePrices("PricesSample.csv");
        HashMap<String, Client> clientsHashMap = parseProduct("ProductSample.csv");
        for (Map.Entry<String, Client> entry : clientsHashMap.entrySet()) {
            entry.getValue().getCapital();
        }

        assertEquals(parseProduct("ProductSample.csv").size(), 5);
        assertEquals(clientsHashMap.get("C1"), C1);
        assertEquals(clientsHashMap.get("C2"), C2);
        assertEquals(clientsHashMap.get("C3"), C3);
        assertEquals(clientsHashMap.get("C4"), C4);
        assertEquals(clientsHashMap.get("C5"), C5);
    }
}