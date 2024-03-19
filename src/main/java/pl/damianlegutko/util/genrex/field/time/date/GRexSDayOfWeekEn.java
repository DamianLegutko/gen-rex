package pl.damianlegutko.util.genrex.field.time.date;

import pl.damianlegutko.util.genrex.base.GRexS;

public class GRexSDayOfWeekEn extends GRexS {
    public GRexSDayOfWeekEn() {
        super("(Monday|Tuesday|Wednesday|Thursday|Friday|Saturday|Sunday)");
    }
}
