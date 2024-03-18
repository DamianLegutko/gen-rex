package pl.damianlegutko.util.genrex.base;

import java.util.function.Supplier;

public class GRexD extends GRexSupplier<Double> {
    public GRexD(Supplier<Double> generationMethod) {
        super(generationMethod);
    }

    public GRexD() {
        super(random::nextDouble);
    }
}
