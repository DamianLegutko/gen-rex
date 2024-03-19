package pl.damianlegutko.util.genrex.field.id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import pl.damianlegutko.util.genrex.base.GRexField;

public class GRexAutoincrementID extends GRexField<Integer> {
    @JsonIgnore
    private static int id;
    @JsonIgnore
    private final int step;

    public GRexAutoincrementID(int step) {
        this.step = step;
    }

    public GRexAutoincrementID() {
        this(1);
    }

    @Override
    protected Integer generateField() {
        id += step;
        return id;
    }
}
