package pl.damianlegutko.util.genrex.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import pl.damianlegutko.util.genrex.util.Serializer;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;
import static pl.damianlegutko.util.genrex.base.ReflectionUtil.generateGenerableFields;
import static pl.damianlegutko.util.genrex.util.Serializer.deepClone;

public abstract class GRexResource<ReturnType> implements ResourceGenerable<ReturnType> {
    @JsonIgnore
    private final List<ReturnType> generatedList = new ArrayList<>();

    @Getter
    @Setter
    @JsonIgnore
    private ReturnType value = null;

    @JsonIgnore
    private final Class<ReturnType> thisEnumType;

    public GRexResource(Class<ReturnType> thisEnumType) {
        this.thisEnumType = thisEnumType;
    }

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
        return addGenerated(generateResource());
    }

    @BeCarefulWhenOverwriting
    private ReturnType generateResource() {
        generateGenerableFields(this);

        return deepClone(this, thisEnumType);
    }

    @Override
    public String toString() {
        if (isNull(value)) generate();

        return Serializer.toJson(this);
    }
}
