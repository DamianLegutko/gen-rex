package pl.damianlegutko.util.genrex.field.time.date;

import pl.damianlegutko.util.genrex.base.GRexS;

public class GRexSDayOfWeekPlShort extends GRexS {
    public GRexSDayOfWeekPlShort() {
        super("(Pon|Wt|Śr|Czw|Pt|Sob|Ndz|Nie)");
    }
}
