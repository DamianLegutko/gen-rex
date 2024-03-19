package pl.damianlegutko.util.genrex.field.person;

import pl.damianlegutko.util.genrex.base.GRexI;

import java.util.function.Supplier;

/**
 * That {@link GRexIAge Age field} has scope from {@code 1 to 122} because
 * the oldest recorded person who is no longer alive was a French woman named Jeanne Calment, who lived to be 122 years and 164 days old.<br>
 * Jeanne Calment was born in 1875 and passed away in 1997, making her the longest-lived human with unambiguously verified documentation.<br>
 * @see GRexIAdultIAge Adult's age field
 * @see GRexITeenAge Teen's age field
 */
public class GRexIAge extends GRexI {
    private static final Supplier<Integer> generationMethod = () -> random.nextInt(122) + 1;

    public GRexIAge() {
        super(generationMethod);
    }
}
