package two;

import one.Permutations;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Optional;
import java.util.Set;

import static one.SolvePuzzle.inputNumbers;
import static org.assertj.core.api.Assertions.assertThat;

class SolvePuzzle {

    @Test
    void findsTripletsOfNumbersThatAddUpTo2020AndMultipliesThem() throws IOException, URISyntaxException {

        Set<Integer> numbers = inputNumbers();

        Optional<Triplet<Integer>> tripletToMultiply =
                Permutations.asTriplets(numbers)
                        .filter((triplet) -> triplet.a() + triplet.b() + triplet.c() == 2020)
                        .findAny();

        assertThat(tripletToMultiply).isPresent();
        assertThat(tripletToMultiply).contains(Triplet.of(1604, 131, 285));

        assertThat(tripletToMultiply.get().a() * tripletToMultiply.get().b() * tripletToMultiply.get().c()).isEqualTo(59885340);
    }

}
