package org.margo.valocb.model;

import lombok.Data;
import java.util.HashSet;

@Data
public class Portfolio implements Priceable {
    private String id;
    private HashSet<Product> pProducts;
    private Float portfolioPrice = 0.0f;

    public Portfolio(String id, HashSet<Product> pProducts){
        this.id = id;
        this.pProducts = pProducts;
    }

    public void addProduct(Product product){
        this.pProducts.add(product);
    }
    public Float getPrice(){
        if (this.portfolioPrice == 0.0f){
            this.price();
        }
        return this.portfolioPrice;
    }

    private void price(){
        this.pProducts.forEach(product -> this.portfolioPrice += product.getPrice());
    }

}
