package fixtures;

import org.margo.valocb.model.Product;
import org.margo.valocb.model.Underlying;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import java.util.HashSet;
import java.util.List;

import static fixtures.UnderlyingFixtures.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductFixtures {
    static HashSet<Underlying> pUnderlyings1 = new HashSet<>(List.of(new Underlying[]{U1, U2}));
    static HashSet<Underlying> pUnderlyings2 = new HashSet<>(List.of(new Underlying[]{U3, U4, U5}));
    static HashSet<Underlying> pUnderlyings3 = new HashSet<>(List.of(new Underlying[]{U6}));

    public static final Product P1 = new Product("P1",pUnderlyings1);
    public static final Product P2 = new Product ( "P2", pUnderlyings2);
    public static final Product P3 = new Product("P3", pUnderlyings3);

}
