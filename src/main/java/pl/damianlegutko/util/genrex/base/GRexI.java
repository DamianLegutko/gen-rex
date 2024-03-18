package pl.damianlegutko.util.genrex.base;

import java.util.function.Supplier;

public class GRexI extends GRexSupplier<Integer> {
    public GRexI(Supplier<Integer> generationMethod) {
        super(generationMethod);
    }

    public GRexI() {
        super(random::nextInt);
    }
}
