package pl.damianlegutko.util.genrex.base;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.IntStream.range;

public interface Generable<ReturnType> extends Jsonable {

    ReturnType generate();

    @BeCarefulWhenOverwriting
    default List<ReturnType> generate(int amountToGenerate) {
        ArrayList<ReturnType> newGenerated = new ArrayList<>();

        range(0, amountToGenerate)
                .forEach(i -> newGenerated.add(generate()));

        return newGenerated;
    }
}
