package one;

import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static shared.Files.linesOf;

public class SolvePuzzle {

    @Test
    void findsPairOfNumbersThatAddUpTo2020AndMultipliesThem() {

        Set<Integer> numbers = inputNumbers();

        Optional<Pair<Integer>> pairToMultiply =
                Permutations.asPairs(numbers)
                .filter((pair) -> pair.l() + pair.r() == 2020)
                .findAny();

        assertThat(pairToMultiply).isPresent();
        assertThat(pairToMultiply).contains(Pair.of(541, 1479));

        assertThat(pairToMultiply.get().l() * pairToMultiply.get().r()).isEqualTo(800139);
    }

    public static Set<Integer> inputNumbers() {
        return linesOf("one/input.txt").map(Integer::parseInt).collect(Collectors.toSet());
    }



}
