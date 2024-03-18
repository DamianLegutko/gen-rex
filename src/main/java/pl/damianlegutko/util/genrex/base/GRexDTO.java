package pl.damianlegutko.util.genrex.base;

public abstract class GRexDTO implements Jsonable {
    @Override
    public String toString() {
        return toJson();
    }
}
