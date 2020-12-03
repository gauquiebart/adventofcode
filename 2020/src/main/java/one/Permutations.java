package one;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

public class Permutations {

    static <T> Stream<Pair<T>> asPairs(Set<T> elements) {
        return elements
                .stream()
                .flatMap(
                        elem -> exclude(elements, elem)
                                .stream()
                                .map(otherElem -> Pair.of(elem, otherElem)));
    }

    public static <T> Stream<Triplet<T>> asTriplets(Set<T> elements) {
        return asPairs(elements)
                .flatMap(
                        pair -> exclude(elements, pair.l(), pair.r())
                                .stream()
                                .map(otherElem -> Triplet.of(pair.l(), pair.r(), otherElem)));
    }

    private static <T> Set<T> exclude(Set<T> elements, T... toExclude) {
        Set<T> result = new HashSet<>(elements);
        result.removeAll(asList(toExclude));
        return result;
    }


}
