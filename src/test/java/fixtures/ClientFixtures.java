package fixtures;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.margo.valocb.model.Client;
import org.margo.valocb.model.Product;

import java.util.HashMap;
import java.util.Map;

import static fixtures.ProductFixtures.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ClientFixtures{

    static HashMap<Product, Float> productsOwned1 = new HashMap<>(Map.of(P1, 10.0f, P2, 20.0f));
    static HashMap<Product, Float> productsOwned2 = new HashMap<>(Map.of(P1, 1.0f, P3, 2.0f));
    static HashMap<Product, Float> productsOwned3 = new HashMap<>(Map.of(P2, 1.0f, P3, 1.0f));
    static HashMap<Product, Float> productsOwned4 = new HashMap<>(Map.of(P1, 10.0f));
    static HashMap<Product, Float> productsOwned5 = new HashMap<>(Map.of(P1, 11.0f, P2, 3.0f, P3, 2.0f));

    public static final Client C1 = new Client("C1", productsOwned1);
    public static final Client C2 = new Client("C2", productsOwned2);
    public static final Client C3 = new Client("C3", productsOwned3);
    public static final Client C4 = new Client("C4", productsOwned4);
    public static final Client C5 = new Client("C5", productsOwned5);
}