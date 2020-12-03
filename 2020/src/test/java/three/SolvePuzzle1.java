package three;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static shared.Files.linesOf;

class SolvePuzzle1 {


    @Test
    void countsTheNumberOfEncounteredTreesWhileTraversingTheLandscape() {
        List<GeologicalPattern> geologicalPatterns = geologicalPatterns();

        long numberOfTrees = numberOfTreesWhileTraversing(geologicalPatterns, 1, 3);


        assertThat(numberOfTrees).isEqualTo(232);
    }

    static long numberOfTreesWhileTraversing(List<GeologicalPattern> geologicalPatterns, int stepDown, int stepRight) {
        return IntStream.iterate(0, i -> i < geologicalPatterns.size(), operand -> operand + stepDown)
                .mapToObj(i -> geologicalPatterns.get(i).elementAt(1 + (i / stepDown) * stepRight) == GeologicalPattern.Element.TREE)
                .filter(Boolean::booleanValue)
                .count();
    }

    static List<GeologicalPattern> geologicalPatterns() {
        return linesOf("three/input.txt")
                .map(GeologicalPattern::of)
                .collect(Collectors.toList());
    }
}
