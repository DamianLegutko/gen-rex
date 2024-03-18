package pl.damianlegutko.util.genrex.base;

/**
 * Default regex '[a-zA-Z]{1,10}'
 */
public class GRexS extends GRexRegex<String> {
    public GRexS() {
        this("[a-zA-Z]{1,10}");
    }

    public GRexS(String regex) {
        setGenerex(regex);
    }

    @Override
    @BeCarefulWhenOverwriting
    protected String generateField() {
        return getGenerex().random();
    }
}
