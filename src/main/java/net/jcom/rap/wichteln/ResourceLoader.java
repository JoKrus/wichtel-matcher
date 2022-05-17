package net.jcom.rap.wichteln;


import com.google.common.io.Resources;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.List;

public class ResourceLoader {
    public static String readResource(final String fileName, Charset charset) {
        try {
            return Resources.toString(Resources.getResource(fileName), charset);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static List<String> readResourceAsList(final String fileName, Charset charset) {
        try {
            return Resources.readLines(Resources.getResource(fileName), charset);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
}
