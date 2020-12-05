package four;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static shared.Files.readFileFromClasspath;

public class SolvePuzzle2 {

    @Test
    void assemblesPassportElementsFromPassportElementsOnMultipleLinesAndCountsTheNumberOfValidPassports() {
        String content = readFileFromClasspath("four/input.txt");

        System.out.println(Arrays.stream(content.split("\\n\\n")).count());

        List<String> passwords =
                Arrays.stream(content.split("\\n\\n"))
                        .map(str -> str.replace("\n", " "))
                        .collect(Collectors.toList());

        long numberOfValidPassports =
                passwords
                .stream()
                        .map(str -> new Passport(PassportElement.parseFrom(str)))
                        .filter(Passport::isValid)
                        .filter(passport -> passport.elements().stream().allMatch(PassportElement::isValid))
                .count();

        assertThat(numberOfValidPassports).isEqualTo(123L);

    }
}
