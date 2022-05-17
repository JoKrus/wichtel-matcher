package net.jcom.rap.wichteln;

import java.nio.charset.Charset;

public class Main {
    public static void main(String[] args) {
        var participantsString = ResourceLoader.readResourceAsList("participantsTEMPLATE.txt",
                Charset.defaultCharset());
        var participants = participantsString.stream().map(s -> {
            var split = s.split(";");
            return new Participant(split[0], split[1]);
        }).toList();

        participants.forEach(System.out::println);
    }
}