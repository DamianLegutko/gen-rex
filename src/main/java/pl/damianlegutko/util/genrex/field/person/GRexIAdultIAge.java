package pl.damianlegutko.util.genrex.field.person;

import pl.damianlegutko.util.genrex.base.GRexI;

import java.util.function.Supplier;

/**
 * That {@link GRexIAdultIAge Adult Age field} has scope from {@code 18 to 122} because
 * the oldest recorded person who is no longer alive was a French woman named Jeanne Calment, who lived to be 122 years and 164 days old.<br>
 * Jeanne Calment was born in 1875 and passed away in 1997, making her the longest-lived human with unambiguously verified documentation.<br>
 * @see GRexIAge Age field
 * @see GRexITeenAge Teen's age field
 */
public class GRexIAdultIAge extends GRexI {
    private static final Supplier<Integer> generationMethod = () -> random.nextInt(122) + 1;

    public GRexIAdultIAge() {
        super(generationMethod);
    }
}
