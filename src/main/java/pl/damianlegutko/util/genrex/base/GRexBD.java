package pl.damianlegutko.util.genrex.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.BigInteger;

import static java.lang.Math.ceil;
import static java.lang.Math.log;
import static pl.damianlegutko.util.genrex.base.GRexBI.randomBigInteger;

/**
 * You have to use it if {@link pl.damianlegutko.util.genrex.base.GRexD} is not enough.
 * {@link pl.damianlegutko.util.genrex.base.GRexD} can generate Double.MAX_VALUE, which is 1.7976931348623157 x 10^308.<br>
 *
 * @see pl.damianlegutko.util.genrex.base.GRexBI GenRex BigInteger field class
 */
public class GRexBD extends GRexField<BigDecimal> {
    @JsonIgnore
    @Getter
    @Setter
    int numberOfBits;

    @JsonIgnore
    @Getter
    int scale;

    @JsonIgnore
    public void setScale(int numberOfBits, int scale) {
        this.numberOfBits = numberOfBits;
        this.scale = scale;
    }

    /**
     * @param precision number of digits for expected BigDecimal generated value. It includes digits after decimal.
     * @Warning It's estimated precision, because number of digits is recalculated into number of bits like (2<sup>numBits</sup> - 1)<br>
     * @see pl.damianlegutko.util.genrex.base.GRexBI GenRex BigInteger field class
     */
    @JsonIgnore
    public void setPrecision(int precision) {
        setPrecision((int) ceil(precision * log(10) / log(2)));
    }

    @Override
    public BigDecimal generateField() {
        return randomBigDecimal();
    }

    public static BigDecimal randomBigDecimal(BigInteger bigInteger, int scale) {
        return new BigDecimal(bigInteger, scale);
    }

    public static BigDecimal randomBigDecimal(int numberOfBits, int scale) {
        return randomBigDecimal(randomBigInteger(numberOfBits), scale);
    }

    @JsonIgnore
    public BigDecimal randomBigDecimal() {
        return randomBigDecimal(getNumberOfBits(), getScale());
    }
}
