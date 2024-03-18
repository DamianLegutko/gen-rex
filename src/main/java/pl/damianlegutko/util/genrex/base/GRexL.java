package pl.damianlegutko.util.genrex.base;

import java.util.function.Supplier;

public class GRexL extends GRexSupplier<Long> {
    public GRexL(Supplier<Long> generationMethod) {
        super(generationMethod);
    }

    public GRexL() {
        super(random::nextLong);
    }
}
