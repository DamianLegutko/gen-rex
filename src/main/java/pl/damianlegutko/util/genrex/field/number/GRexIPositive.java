package pl.damianlegutko.util.genrex.field.number;

import pl.damianlegutko.util.genrex.base.GRexI;

import static java.lang.Integer.MAX_VALUE;

public class GRexIPositive extends GRexI {
    public GRexIPositive() {
        super(() -> random.nextInt(MAX_VALUE));
    }
}
