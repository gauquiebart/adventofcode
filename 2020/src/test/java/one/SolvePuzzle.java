package one;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.Set;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;
import static org.assertj.core.api.Assertions.assertThat;

public class SolvePuzzle {

    @Test
    void findsPairOfNumbersThatAddUpTo2020AndMultipliesThem() throws IOException, URISyntaxException {

        Set<Integer> numbers = inputNumbers();

        Optional<Pair<Integer>> pairToMultiply =
                Permutation.asPairs(numbers)
                .filter((pair) -> pair.l() + pair.r() == 2020)
                .findAny();

        assertThat(pairToMultiply).isPresent();
        assertThat(pairToMultiply).contains(Pair.of(541, 1479));

        assertThat(pairToMultiply.get().l() * pairToMultiply.get().r()).isEqualTo(800139);
    }

    public static Set<Integer> inputNumbers() throws IOException, URISyntaxException {
        String fileContent = readFileFromClasspath("one/input.txt");
        return stream(fileContent.split("\\n")).map(Integer::parseInt).collect(Collectors.toSet());
    }

    public static String readFileFromClasspath(final String fileName) throws IOException, URISyntaxException {
        return new String(Files.readAllBytes(
                Paths.get(PermutationTest.class.getClassLoader()
                        .getResource(fileName)
                        .toURI())));
    }}
