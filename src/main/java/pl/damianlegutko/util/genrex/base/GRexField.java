package pl.damianlegutko.util.genrex.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.time.OffsetDateTime.now;

public abstract class GRexField<ReturnType> implements FieldGenerable<ReturnType> {
    @JsonIgnore
    protected static final Random random = new Random(now().toEpochSecond());
    @JsonIgnore
    private final List<ReturnType> generatedList = new ArrayList<>();

    @Getter
    @JsonValue
    private ReturnType value = null;

    protected abstract ReturnType generateField();

    @JsonIgnore
    private ReturnType addGenerated(ReturnType justGenerated) {
        value = justGenerated;

        this.generatedList.add(value);

        return value;
    }

    @JsonIgnore
    @BeCarefulWhenOverwriting
    public final List<ReturnType> getAllGenerated() {
        return generatedList.stream()
                .toList();
    }

    @Override
    public final ReturnType generate() {
        return addGenerated(generateField());
    }

    @Override
    public String toString() {
        return toJson();
    }
}
