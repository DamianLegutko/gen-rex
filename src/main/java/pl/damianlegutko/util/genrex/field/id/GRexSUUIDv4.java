package pl.damianlegutko.util.genrex.field.id;

import pl.damianlegutko.util.genrex.base.GRexS;

public class GRexSUUIDv4 extends GRexS {
    public GRexSUUIDv4() {
        super("[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-4[0-9a-fA-F]{3}-[89abAB][0-9a-fA-F]{3}-[0-9a-fA-F]{12}");
    }
}
