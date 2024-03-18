package pl.damianlegutko.util.genrex.base;

import java.util.function.Supplier;

public class GRexF extends GRexSupplier<Float> {
    public GRexF(Supplier<Float> generationMethod) {
        super(generationMethod);
    }

    public GRexF() {
        super(random::nextFloat);
    }
}
