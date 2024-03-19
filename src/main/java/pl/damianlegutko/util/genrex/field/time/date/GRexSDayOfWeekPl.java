package pl.damianlegutko.util.genrex.field.time.date;

import pl.damianlegutko.util.genrex.base.GRexS;

public class GRexSDayOfWeekPl extends GRexS {
    public GRexSDayOfWeekPl() {
        super("(Poniedziałek|Wtorek|Środa|Czwartek|Piątek|Sobota|Niedziela)");
    }
}
