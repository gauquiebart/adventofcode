package shared;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static java.util.Arrays.stream;

public class Files {

    public static Stream<String> linesOf(String fileFromClassPath) {
        try {
            return stream(readFileFromClasspath(fileFromClassPath).split("\\n"));
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }


    public static String readFileFromClasspath(final String fileName) throws IOException, URISyntaxException {
        return new String(java.nio.file.Files.readAllBytes(
                Paths.get(Files.class.getClassLoader()
                        .getResource(fileName)
                        .toURI())));
    }
}
