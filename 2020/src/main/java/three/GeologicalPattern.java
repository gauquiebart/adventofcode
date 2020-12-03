package three;

import shared.ValueObject;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static three.GeologicalPattern.Element.OPEN;
import static three.GeologicalPattern.Element.TREE;

class GeologicalPattern extends ValueObject {

    private final List<Element> elements;

    private GeologicalPattern(List<Element> elements) {
        this.elements = new ArrayList<>(elements);
    }

    static GeologicalPattern of(Element... elements) {
        return new GeologicalPattern(asList(elements));
    }

    static GeologicalPattern of(String encodedElements) {
        return new GeologicalPattern(
                encodedElements
                .chars()
                .mapToObj(c -> (char) c)
                .map((character -> {
                    if(character == '.') {
                        return OPEN;
                    } else if (character == '#') {
                        return TREE;
                    } else
                    throw new IllegalArgumentException("i dont understand " + character);
                }))
                .collect(Collectors.toList()));
    }

    Element elementAt(int oneBasedIndex) {
        return elements.get((oneBasedIndex - 1) % elements.size());
    }

    enum Element {
        TREE,
        OPEN
    }
}
