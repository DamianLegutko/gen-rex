package pl.damianlegutko.util.genrex.base;

import java.util.function.Supplier;

/**
 * That {@link pl.damianlegutko.util.genrex.base.GRexField Field} can generate value for scope from 0 to {@link java.lang.Long#MAX_VALUE}, which is 9,223,372,036,854,775,807 (2<sup>63</sup> - 1).
 */
public class GRexL extends GRexSupplier<Long> {
    public GRexL(Supplier<Long> generationMethod) {
        super(generationMethod);
    }

    public GRexL() {
        super(random::nextLong);
    }
}
