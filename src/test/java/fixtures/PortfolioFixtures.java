package fixtures;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.margo.valocb.model.Portfolio;
import org.margo.valocb.model.Product;

import java.util.HashSet;
import java.util.List;

import static fixtures.ProductFixtures.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PortfolioFixtures {

    static HashSet<Product> pProducts1 = new HashSet<>(List.of(new Product[]{P1, P2}));
    static HashSet<Product> pProducts2 = new HashSet<>(List.of(new Product[]{P3}));
    public static final Portfolio PTF1 = new Portfolio("PTF1", pProducts1);
    public static final Portfolio PTF2 = new Portfolio("PTF2", pProducts2);


}