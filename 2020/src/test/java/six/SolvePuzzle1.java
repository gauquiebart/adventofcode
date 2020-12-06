package six;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static shared.Files.readFileFromClasspath;

class SolvePuzzle1 {

    @Test
    void countTotalOfUniqueAnswersOfEachGroupWithTestInput() {
        String content = readFileFromClasspath("six/testinput.txt");

        Long totalAnswersCount = Arrays.stream(content.split("\\n\\n"))
                .map(str -> str.replace("\n", ""))
                .map(str -> str.chars().mapToObj(c -> (char) c))
                .map(Stream::distinct)
                .map(Stream::count)
                .reduce(0l, Long::sum);

        assertThat(totalAnswersCount).isEqualTo(11L);

    }

    @Test
    void countTotalOfUniqueAnswersOfEachGroup() {
        String content = readFileFromClasspath("six/input.txt");

        Long totalAnswersCount = Arrays.stream(content.split("\\n\\n"))
                .map(str -> str.replace("\n", ""))
                .map(str -> str.chars().mapToObj(c -> (char) c))
                .map(Stream::distinct)
                .map(Stream::count)
                .reduce(0l, Long::sum);

        assertThat(totalAnswersCount).isEqualTo(6703L);
    }
}
