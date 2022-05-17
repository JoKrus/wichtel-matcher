package net.jcom.rap.wichteln;

import org.apache.commons.lang3.tuple.Pair;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        OutputStrategy outputStrategy = new ConsoleOutput();

        var participantsString = ResourceLoader.readResourceAsList("participants.txt", Charset.defaultCharset());
        var participants = participantsString.stream().map(s -> {
            var split = s.split(";");
            return new Participant(split[0], split[1]);
        }).toList();

        var opponents = new ArrayList<>(participants);

        do {
            Collections.shuffle(opponents);
        } while (checkSelfOpponent(participants, opponents));

        var pairList = new ArrayList<Pair<Participant, Participant>>();

        for (int i = 0; i < participants.size(); ++i) {
            pairList.add(Pair.of(participants.get(i), opponents.get(i)));
        }

        outputStrategy.writeOutput(pairList);
    }

    private static boolean checkSelfOpponent(List<Participant> participants, ArrayList<Participant> opponents) {
        for (int i = 0; i < participants.size(); i++) {
            Participant participant = participants.get(i);
            Participant opponent = opponents.get(i);

            if (participant.name().equals(opponent.name())) {
                return true;
            }
        }
        return false;
    }
}