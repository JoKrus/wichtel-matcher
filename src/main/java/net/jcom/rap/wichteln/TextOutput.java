package net.jcom.rap.wichteln;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.tuple.Pair;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

public class TextOutput implements OutputStrategy {
    private static String fileName = "results.txt";

    @Override
    public void writeOutput(List<Pair<Participant, Participant>> matches) {
        StringBuilder output = new StringBuilder();

        for (var match : matches) {
            output.append(match.getLeft().name()).append("->").append(match.getRight().name()).append(System.lineSeparator());
        }

        output.append(System.lineSeparator());
        output.append(System.lineSeparator());

        try {
            FileUtils.write(new File(fileName), output, Charset.defaultCharset(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
