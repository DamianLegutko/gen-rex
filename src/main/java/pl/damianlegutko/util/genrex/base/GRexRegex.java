package pl.damianlegutko.util.genrex.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mifmif.common.regex.Generex;
import dk.brics.automaton.Automaton;
import dk.brics.automaton.RegExp;
import lombok.Getter;

public abstract class GRexRegex<ReturnType> extends GRexField<ReturnType> {
    @Getter
    @JsonIgnore
    String regex;
    RegExp regExp;
    Automaton automaton;
    @Getter
    @JsonIgnore
    Generex generex;

    protected final void setGenerex(String regex) {
        this.regex = regex;
        regExp = new RegExp(this.regex);
        automaton = regExp.toAutomaton();
        generex = new Generex(automaton);
    }

    public GRexRegex() {
        this("[a-zA-Z]{1,10}");
    }

    public GRexRegex(String regex) {
        super();
        setGenerex(regex);
    }
}
