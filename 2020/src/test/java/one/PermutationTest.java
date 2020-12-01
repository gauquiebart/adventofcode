package one;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class PermutationTest {

    @Test
    void generatesAllPairs() {
        String A = "A";
        String B = "B";
        String C = "C";
        String D = "D";

        Set<String> elements = new HashSet<>(Arrays.asList(A, B, C, D));

        assertThat(Permutation.asPairs(elements)).contains(Pair.of(A, B),
                Pair.of(A, C),
                Pair.of(A, D),
                Pair.of(B, A),
                Pair.of(B, C),
                Pair.of(B, D),
                Pair.of(C, A),
                Pair.of(C, B),
                Pair.of(C, D),
                Pair.of(D, A),
                Pair.of(D, B),
                Pair.of(D, C));
    }
}
