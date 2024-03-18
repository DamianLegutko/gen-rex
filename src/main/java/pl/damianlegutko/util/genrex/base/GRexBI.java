package pl.damianlegutko.util.genrex.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.util.Random;

/**
 * You can use it that class if {@link pl.damianlegutko.util.genrex.base.GRexL} has too small scope.<br>
 * {@link pl.damianlegutko.util.genrex.base.GRexL} can generate max value equal to {@link java.lang.Long#MAX_VALUE}, which is 9,223,372,036,854,775,807 (2<sup>63</sup> - 1).<br>
 * Note that this constructor always constructs a non-negative BigInteger.<br>
 *
 * @see java.math.BigInteger#bitLength()
 */
public class GRexBI extends GRexField<BigInteger> {
    @JsonIgnore
    @Setter
    @Getter
    int numberOfBits;

    /**
     * Uniformly distributed over the range 0 to (2<sup>numBits</sup> - 1), inclusive.<br>
     * The uniformity of the distribution assumes that a fair source of random bits.<br>
     *
     * @param numberOfBits max bit lengh of a new {@link  java.math.BigInteger}.
     * @throws IllegalArgumentException if {@code numberOfBits} is negative.
     * @see java.math.BigInteger#bitLength()
     */
    public GRexBI(int numberOfBits) {
        new BigInteger(numberOfBits, random);
    }


    /**
     * That non args constructor uses {@link pl.damianlegutko.util.genrex.base.GRexBI#GRexBI(int) new GRexBI(int numberOfBits)} constructor with default value 128 {@code numberOfBits}.<br>
     * Uniformly distributed over the range from 0 to (2<sup>128</sup> - 1) inclusive which is.
     */
    public GRexBI() {
        this(128);
    }

    /**
     * Generates a new {@link java.math.BigInteger} instance with a specified maximum bit length.
     * <p>
     * This method overrides an existing method to provide a specific implementation for generating
     * a {@link java.math.BigInteger} {@link pl.damianlegutko.util.genrex.base.GRexField Field}.<br>
     * The generated {@link java.math.BigInteger} instance has a bit length up to the specified {@code numberOfBits}
     * and is created using the provided {@code random} instance  for randomness.
     * </p>
     *
     * @return A new {@code BigInteger} instance with a maximum bit length specified by {@code numberOfBits}.
     * @throws IllegalArgumentException if {@code numberOfBits} is negative.
     */
    @Override
    public BigInteger generateField() {
        return randomBigInteger();
    }

    public static BigInteger randomBigInteger(int numberOfBits, Random random) {
        return new BigInteger(numberOfBits, random);
    }

    public static BigInteger randomBigInteger(int numberOfBits) {
        return randomBigInteger(numberOfBits, random);
    }

    @JsonIgnore
    public BigInteger randomBigInteger() {
        return randomBigInteger(getNumberOfBits(), random);
    }
}
