package six;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;
import static shared.Files.readFileFromClasspath;

class SolvePuzzle2 {

    @Test
    void countTotalOfUniqueAnswersOfEachGroupWithTestInput() {
        String content = readFileFromClasspath("six/testinput.txt");

        int totalAnswersCount
         = stream(content.split("\\n\\n"))
                .map(str -> str.split("\\n"))
                .map(stringArray -> stream(stringArray)
                                    .map(str -> str.chars().mapToObj(c -> (char) c).collect(toList()))
                                    .collect(toList()))
                .map(answersPerGroup ->
                        answersPerGroup.stream()
                                .reduce(new HashSet<Character>(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z')),
                                        (answeredByAllInGroup, answersForPerson) -> {
                                                answeredByAllInGroup.retainAll(answersForPerson);
                                                return answeredByAllInGroup;
                                        },
                                        (identity, answeredByAllInGroup) -> answeredByAllInGroup))
                .map(Set::size)
                .reduce(0, Integer::sum);

        assertThat(totalAnswersCount).isEqualTo(6);
    }

    @Test
    void countTotalOfUniqueAnswersOfEachGroup() {
        String content = readFileFromClasspath("six/input.txt");

        int totalAnswersCount
                = stream(content.split("\\n\\n"))
                .map(str -> str.split("\\n"))
                .map(stringArray -> stream(stringArray)
                        .map(str -> str.chars().mapToObj(c -> (char) c).collect(toList()))
                        .collect(toList()))
                .map(answersPerGroup ->
                        answersPerGroup.stream()
                                .reduce(new HashSet<Character>(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z')),
                                        (answeredByAllInGroup, answersForPerson) -> {
                                            answeredByAllInGroup.retainAll(answersForPerson);
                                            return answeredByAllInGroup;
                                        },
                                        (identity, answeredByAllInGroup) -> answeredByAllInGroup))
                .map(Set::size)
                .reduce(0, Integer::sum);

        assertThat(totalAnswersCount).isEqualTo(3430);
    }
}
