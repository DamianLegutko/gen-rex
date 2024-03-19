package pl.damianlegutko.util.genrex.field.id;

import pl.damianlegutko.util.genrex.base.GRexField;

import java.util.UUID;

import static java.util.UUID.randomUUID;

public class GRexUUID extends GRexField<UUID> {
    @Override
    protected UUID generateField() {
        return randomUUID();
    }
}
