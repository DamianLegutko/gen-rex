package pl.damianlegutko.util.genrex.base;

import pl.damianlegutko.util.genrex.util.Serializer;

public interface Jsonable {
    @BeCarefulWhenOverwriting
    default String toJson() {
        return Serializer.toJson(this);
    }
}
