package net.jcom.rap.wichteln;

import org.apache.commons.lang3.tuple.Pair;

import java.util.List;

public class ConsoleOutput implements OutputStrategy {
    @Override
    public void writeOutput(List<Pair<Participant, Participant>> matches) {
        for (var match : matches) {
            System.out.printf("%s battlet gegen %s%n", match.getLeft(), match.getRight());
        }
    }
}
