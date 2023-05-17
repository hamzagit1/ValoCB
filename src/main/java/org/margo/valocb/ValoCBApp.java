package org.margo.valocb;

import org.margo.valocb.controller.CSVGenerator;

import java.io.File;
import java.io.IOException;


public class ValoCBApp {
    public static void main(String[] args) throws IOException {
        //Create output folder
        File OutputDirectory = new File("./output");
        OutputDirectory.mkdir();

        //Generating the outputs:
        CSVGenerator.generatePortfoliosReport();
        CSVGenerator.generateClientsReport();
        }
}