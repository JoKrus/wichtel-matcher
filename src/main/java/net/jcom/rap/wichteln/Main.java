package net.jcom.rap.wichteln;

import org.apache.commons.lang3.tuple.Pair;

import java.nio.charset.Charset;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        OutputStrategy outputStrategy = new ConsoleOutput();
        SecureRandom random = new SecureRandom();

        var participantsString = ResourceLoader.readResourceAsList("participants.txt", Charset.defaultCharset());
        var participants = participantsString.stream().map(s -> {
            var split = s.split(";");
            return new Participant(split[0], split[1]);
        }).collect(Collectors.toCollection(ArrayList::new));

        Collections.shuffle(participants, random);

        var pairList = new ArrayList<Pair<Participant, Participant>>();

        for (int i = 0; i < participants.size(); ++i) {
            pairList.add(Pair.of(participants.get(i), participants.get((i + 1) % participants.size())));
        }

        outputStrategy.writeOutput(pairList);
    }
}
