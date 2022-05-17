package net.jcom.rap.wichteln;

import org.apache.commons.lang3.tuple.Pair;

import java.util.List;

@FunctionalInterface
public interface OutputStrategy {
    void writeOutput(List<Pair<Participant, Participant>> matches);
}
