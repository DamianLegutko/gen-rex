package pl.damianlegutko.util.genrex.field.time.date;

import pl.damianlegutko.util.genrex.base.GRexS;

public class GRexSDayOfWeekEnShort extends GRexS {
    public GRexSDayOfWeekEnShort() {
        super("(Mon|Tue|Wed|Thu|Fri|Sat|Sun)");
    }
}
