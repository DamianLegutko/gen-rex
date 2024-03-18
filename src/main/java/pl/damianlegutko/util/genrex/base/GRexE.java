package pl.damianlegutko.util.genrex.base;

public class GRexE<ReturnType extends Enum<ReturnType>> extends GRexSupplier<ReturnType> {
    private final Class<ReturnType> thisEnumType;

    public GRexE(Class<ReturnType> thisEnumType) {
        super(() -> thisEnumType.getEnumConstants()[random.nextInt(thisEnumType.getEnumConstants().length)]);
        this.thisEnumType = thisEnumType;
    }
}
