package org.margo.valocb.controller;

import org.margo.valocb.model.Client;
import org.margo.valocb.model.Portfolio;
import org.margo.valocb.model.Priceable;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.margo.valocb.controller.CSVParser.*;

public class CSVGenerator {

    public static void generatePortfoliosReport() throws IOException{
        String filePath = "./output/Reporting-portfolio.csv";

        FileWriter writer = new FileWriter(filePath);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);

        // Write the Header
        bufferedWriter.write("PTF, Price\n");
        for (Map.Entry<String, Portfolio> entry : parsePrices("Prices.csv").entrySet()) {
            String PTF = entry.getKey();
            Float Price = entry.getValue().getPrice();
            bufferedWriter.write(PTF + "," + Price + "\n");
        }
        bufferedWriter.close();
  }

    public static void generateClientsReport() throws IOException{
        String filePath = "./output/Reporting-client.csv";

        FileWriter writer = new FileWriter(filePath);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);

        // Write the Header
        bufferedWriter.write("Client, Capital\n");

        for (Map.Entry<String, Client> entry : parseProduct("Product.csv").entrySet()) {
            String Client = entry.getKey();
            Float Capital = entry.getValue().getCapital();
            bufferedWriter.write(Client + "," + Capital + "\n");
        }
        bufferedWriter.close();
    }

}
