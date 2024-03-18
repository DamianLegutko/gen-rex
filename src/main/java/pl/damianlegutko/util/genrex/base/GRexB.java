package pl.damianlegutko.util.genrex.base;

import java.util.function.Supplier;

public class GRexB extends GRexSupplier<Boolean> {

    public GRexB(Supplier<Boolean> generationMethod) {
        super(generationMethod);
    }

    public GRexB() {
        super(random::nextBoolean);
    }
}
