package four;

import shared.ValueObject;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Passport extends ValueObject {

    private final List<PassportElement> elements;

    Passport(List<PassportElement> elements) {
        this.elements = elements;
    }

    boolean isValid() {
        return elements.size() == 8 ||
                (elements.size() == 7
                        && !elements.stream().map(passportElement -> passportElement.type()).collect(Collectors.toList()).contains(PassportElementType.COUNTRY_ID));
    }

    List<PassportElement> elements() {
        return Collections.unmodifiableList(elements);
    }

}
