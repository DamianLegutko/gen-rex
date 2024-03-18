package pl.damianlegutko.util.genrex.base;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.function.Supplier;

public class GRexSupplier<ReturnType> extends GRexField<ReturnType> {
    @JsonIgnore
    protected Supplier<ReturnType> generationMethod;

    public GRexSupplier(Supplier<ReturnType> generationMethod) {
        this.generationMethod = generationMethod;
    }

    @Override
    protected final ReturnType generateField() {
        return generationMethod.get();
    }
}
