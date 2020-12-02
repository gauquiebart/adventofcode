package one;

import org.junit.jupiter.api.Test;
import two.Triplet;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class PermutationsTest {

    @Test
    void generatesAllPairs() {
        String A = "A";
        String B = "B";
        String C = "C";
        String D = "D";

        Set<String> elements = new HashSet<>(Arrays.asList(A, B, C, D));

        assertThat(Permutations.asPairs(elements)).contains(
                Pair.of(A, B),
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

    @Test
    void generatesAllTriplets() {
        String A = "A";
        String B = "B";
        String C = "C";
        String D = "D";

        Set<String> elements = new HashSet<>(Arrays.asList(A, B, C, D));

        assertThat(Permutations.asTriplets(elements)).contains(
                Triplet.of(A, B, C),
                Triplet.of(A, B, D),
                Triplet.of(A, C, B),
                Triplet.of(A, C, D),
                Triplet.of(A, D, B),
                Triplet.of(A, D, C),
                Triplet.of(B, A, C),
                Triplet.of(B, A, D),
                Triplet.of(B, C, A),
                Triplet.of(B, C, D),
                Triplet.of(B, D, A),
                Triplet.of(B, D, C),
                Triplet.of(C, A, B),
                Triplet.of(C, A, D),
                Triplet.of(C, B, A),
                Triplet.of(C, B, D),
                Triplet.of(C, D, A),
                Triplet.of(C, D, B),
                Triplet.of(D, A, B),
                Triplet.of(D, A, C),
                Triplet.of(D, B, A),
                Triplet.of(D, B, C),
                Triplet.of(D, C, A),
                Triplet.of(D, C, B));
    }
}
