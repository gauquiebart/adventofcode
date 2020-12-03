package three;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static three.SolvePuzzle1.geologicalPatterns;
import static three.SolvePuzzle1.numberOfTreesWhileTraversing;

class SolvePuzzle2 {


    @Test
    void countsTheNumberOfEncounteredTreesWhileTraversingTheLandscape() {
        List<GeologicalPattern> geologicalPatterns = geologicalPatterns();

        long numberOfTreesTraverse1Down1Right = numberOfTreesWhileTraversing(geologicalPatterns, 1, 1);
        long numberOfTreesTraverse1Down3Right = numberOfTreesWhileTraversing(geologicalPatterns, 1, 3);
        long numberOfTreesTraverse1Down5Right = numberOfTreesWhileTraversing(geologicalPatterns, 1, 5);
        long numberOfTreesTraverse1Down7Right = numberOfTreesWhileTraversing(geologicalPatterns, 1, 7);
        long numberOfTreesTraverse2Down1Right = numberOfTreesWhileTraversing(geologicalPatterns, 2, 1);

        assertThat(numberOfTreesTraverse1Down1Right
                * numberOfTreesTraverse1Down3Right
                * numberOfTreesTraverse1Down5Right
                * numberOfTreesTraverse1Down7Right
                * numberOfTreesTraverse2Down1Right).isEqualTo(12L);


    }
}
