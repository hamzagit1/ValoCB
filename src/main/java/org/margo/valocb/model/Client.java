package org.margo.valocb.model;

import lombok.Data;
import java.util.HashMap;

@Data
public class Client {
    private String id;
    private HashMap<Product, Float> productsOwned;
    private Float clientCapital = 0.0f;

    public Client(String id, HashMap<Product, Float> productsOwned){
        this.id = id;
        this.productsOwned = productsOwned;
    }

    public void addQtyProduct(Product product, Float quantity){
        this.productsOwned.put(product, quantity);
    }
    public Float getCapital(){
        if (this.clientCapital == 0.0f){
            this.capital();
        }
        return this.clientCapital;
    }

    private void capital(){
        for (Product product : productsOwned.keySet()){
            this.clientCapital += product.getPrice() * productsOwned.get(product);
        }
    }

}