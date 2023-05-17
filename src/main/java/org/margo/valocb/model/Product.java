package org.margo.valocb.model;

import java.util.HashSet;
import java.util.Objects;


public class Product implements Priceable {
    private String id;
    private HashSet<Underlying> pUnderlyings;
    private Float productPrice = 0.0f;

    public Product(String id, HashSet<Underlying> pUnderlyings){
        this.id = id;
        this.pUnderlyings = pUnderlyings;
    }
    public void addUnderlying(Underlying underlying){
        this.pUnderlyings.add(underlying);
    }
    public Float getPrice(){
        if (this.productPrice == 0.0f){
            this.price();
        }
        return this.productPrice;
    }

    private void price(){
        this.pUnderlyings.forEach(underlying -> this.productPrice += underlying.getPrice());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        Product prod = (Product) o;
        return this.id.equals(prod.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

}