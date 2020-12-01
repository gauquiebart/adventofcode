package one;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class Permutation {

    static <T> Stream<Pair<T>> asPairs(Set<T> elements) {
        return elements
                .stream()
                .flatMap(
                        elem -> exclude(elem, elements)
                                .stream()
                                .map(otherElem -> Pair.of(elem, otherElem)));
    }

    private static <T> Set<T> exclude(T elem, Set<T> elements) {
        Set<T> result = new HashSet<>(elements);
        result.remove(elem);
        return result;
    }
}
