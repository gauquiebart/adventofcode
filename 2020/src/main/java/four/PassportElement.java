package four;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class PassportElement {

    private final PassportElementType type;
    private final String rawValue;

    private PassportElement(PassportElementType type, String rawValue) {
        this.type = type;
        this.rawValue = rawValue;
    }

    boolean isValid() {
        return type.valid(rawValue);
    }

    PassportElementType type() {
        return type;
    }

    static List<PassportElement> parseFrom(String multiplePassportElements) {
        return stream(multiplePassportElements.split(" "))
                .map(part -> new PassportElement(PassportElementType.of(part.split(":")[0]),
                        part.split(":")[0]))
                .collect(Collectors.toList());

    }
}
