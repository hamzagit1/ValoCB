package fixtures;

import org.margo.valocb.model.Underlying;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UnderlyingFixtures {
    public static final Underlying U1 = new Underlying("U1", "USD", 10);
    public static final Underlying U2 = new Underlying("U2", "EUR", 5);
    public static final Underlying U3 = new Underlying("U3", "CHF", 2.5f);
    public static final Underlying U4 = new Underlying("U4", "GPB", 2);
    public static final Underlying U5 = new Underlying("U5", "JPY", 100);
    public static final Underlying U6 = new Underlying("U6", "TND", 30);

}