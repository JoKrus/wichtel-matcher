package net.jcom.rap.wichteln;


import com.google.common.io.Resources;

import java.io.IOException;
import java.nio.charset.Charset;

public class ResourceLoader {
    public static String readResource(final String fileName, Charset charset) throws IOException {
        return Resources.toString(Resources.getResource(fileName), charset);
    }
}
