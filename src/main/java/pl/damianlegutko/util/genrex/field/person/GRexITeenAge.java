package pl.damianlegutko.util.genrex.field.person;

import pl.damianlegutko.util.genrex.base.GRexI;

import java.util.function.Supplier;

/**
 * That {@link GRexITeenAge Teen Age field} has scope from {@code 13 to 19}<br>
 * @see GRexIAdultIAge Adult's age field
 * @see GRexIAge Age field
 */
public class GRexITeenAge extends GRexI {
    private static final Supplier<Integer> generationMethod = () -> random.nextInt(7) + 13;

    public GRexITeenAge() {
        super(generationMethod);
    }
}
