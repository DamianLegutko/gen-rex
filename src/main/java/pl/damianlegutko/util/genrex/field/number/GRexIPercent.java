package pl.damianlegutko.util.genrex.field.number;

import pl.damianlegutko.util.genrex.base.GRexI;

public class GRexIPercent extends GRexI {
    public GRexIPercent() {
        super(() -> random.nextInt(101));
    }
}
