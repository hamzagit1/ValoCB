package org.margo.valocb.controller;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.margo.valocb.model.Client;
import org.margo.valocb.model.Portfolio;
import org.margo.valocb.model.Product;
import org.margo.valocb.model.Underlying;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;

public class CSVParser {
    static HashMap<String, Underlying> ALLUNDERLYINGS = new HashMap<>();
    static HashMap<String, Product> ALLPRODUCTS = new HashMap<>();

    public static HashMap<String, Float> parseForex(final String forexFilePath) {
        HashMap<String, Float> FOREX = new HashMap<>();
        InputStream inputStream = CSVParser.class.getClassLoader().getResourceAsStream(forexFilePath);

        try {
            assert inputStream != null;
            try (CSVReader reader = new CSVReader(new BufferedReader(new InputStreamReader(inputStream)))) {
                reader.readNext(); //Read the header
                String[] nextRow;

                while ((nextRow = reader.readNext()) != null) {
                    String currency1 = nextRow[0];
                    String currency2 = nextRow[1];
                    float rate;
                    String currency;

                    if (currency1.equals("EUR")) {
                        currency = currency2;
                        rate = 1 / Float.parseFloat(nextRow[2]);
                    } else {
                        currency = currency1;
                        rate = Float.parseFloat(nextRow[2]);
                    }
                    FOREX.put(currency, rate);
                }
                FOREX.put("EUR", 1.0f);
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }

        return FOREX;
    }

    public static HashMap<String, Portfolio> parsePrices(final String pricesFilePath) {
        HashMap<String, Portfolio> ALLPORTFOLIOS = new HashMap<>();
        InputStream inputStream = CSVParser.class.getClassLoader().getResourceAsStream(pricesFilePath);

        try {
            assert inputStream != null;
            try (CSVReader reader = new CSVReader(new BufferedReader(new InputStreamReader(inputStream)))) {
                reader.readNext(); //Read the header
                String[] nextRow;

                while ((nextRow = reader.readNext()) != null) {
                    String portfolioId = nextRow[0];
                    String productId = nextRow[1];
                    String underlyingId = nextRow[2];
                    String currency = nextRow[3];
                    float rawPrice = Float.parseFloat(nextRow[4]);

                    Underlying currentUnderlying = createUnderlying(underlyingId, currency, rawPrice, ALLUNDERLYINGS);
                    Product currentProduct = addUnderlyingToProduct(productId, currentUnderlying, ALLPRODUCTS);
                    Portfolio currentPortfolio = addProductToPortfolio(portfolioId, currentProduct, ALLPORTFOLIOS);
                }
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }

        return ALLPORTFOLIOS;
    }

    private static Underlying createUnderlying(String underlyingId, String currency, Float rawPrice, HashMap<String, Underlying> ALLUNDERLYINGS) {
        Underlying currentUnderlying;
        if (!ALLUNDERLYINGS.containsKey(underlyingId)) {
            currentUnderlying = new Underlying(underlyingId, currency, rawPrice);
            ALLUNDERLYINGS.put(underlyingId, currentUnderlying);
        }
        return ALLUNDERLYINGS.get(underlyingId);
    }

    private static Product addUnderlyingToProduct(String productId, Underlying currentUnderlying, HashMap<String, Product> ALLPRODUCTS) {
        if (ALLPRODUCTS.containsKey(productId)) {
            ALLPRODUCTS.get(productId).addUnderlying(currentUnderlying);
        } else {
            HashSet<Underlying> pUnderlyings = new HashSet<>();
            pUnderlyings.add(currentUnderlying);
            Product currentProduct = new Product(productId, pUnderlyings);
            ALLPRODUCTS.put(productId, currentProduct);
        }
        return ALLPRODUCTS.get(productId);
    }

    private static Portfolio addProductToPortfolio(String portfolioId, Product currentProduct, HashMap<String, Portfolio> ALLPORTFOLIOS) {
        if (ALLPORTFOLIOS.containsKey(portfolioId)) {
            if (!ALLPORTFOLIOS.get(portfolioId).getPProducts().contains(currentProduct)) {
                ALLPORTFOLIOS.get(portfolioId).addProduct(currentProduct);
            }
        } else {
            HashSet<Product> pProducts = new HashSet<>();
            pProducts.add(currentProduct);
            Portfolio currentPortfolio = new Portfolio(portfolioId, pProducts);
            ALLPORTFOLIOS.put(portfolioId, currentPortfolio);
        }
        return ALLPORTFOLIOS.get(portfolioId);
    }


    public static HashMap<String, Client> parseProduct(final String productFilePath) {
        HashMap<String, Client> ALLCLIENTS = new HashMap<>();
        InputStream inputStream = CSVParser.class.getClassLoader().getResourceAsStream(productFilePath);

        try {
            assert inputStream != null;
            try (CSVReader reader = new CSVReader(new BufferedReader(new InputStreamReader(inputStream)))) {
                reader.readNext(); //Read the header
                String[] nextRow;

                while ((nextRow = reader.readNext()) != null) {
                    String productId = nextRow[0];
                    String clientId = nextRow[1];
                    float quantity = Float.parseFloat(nextRow[2]);

                    Client currentClient = addProductToClient(clientId, productId, quantity, ALLCLIENTS);
                }
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }

        return ALLCLIENTS;
    }

    private static Client addProductToClient(String clientId, String productId, float quantity, HashMap<String, Client> ALLCLIENTS) {
        if (ALLCLIENTS.containsKey(clientId)) {
            ALLCLIENTS.get(clientId).addQtyProduct(ALLPRODUCTS.get(productId), quantity);
        } else {
            HashMap<Product, Float> productsOwned = new HashMap<Product, Float>();
            productsOwned.put(ALLPRODUCTS.get(productId), quantity);
            Client newClient = new Client(clientId, productsOwned);
            ALLCLIENTS.put(clientId, newClient);
        }
        return ALLCLIENTS.get(clientId);
    }

}
