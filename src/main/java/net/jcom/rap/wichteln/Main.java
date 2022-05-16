package net.jcom.rap.wichteln;

import java.io.IOException;
import java.nio.charset.Charset;

public class Main {
    public static void main(String[] args) {
        String out;
        try {
            out = ResourceLoader.readResource("participantsTEMPLATE.txt", Charset.defaultCharset());
        } catch (IOException ignore) {
            out = "Hello world!";
        }
        System.out.println(out);
    }
}