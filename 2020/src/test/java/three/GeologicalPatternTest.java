package three;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static three.GeologicalPattern.Element.OPEN;
import static three.GeologicalPattern.Element.TREE;

class GeologicalPatternTest {

    @Test
    void returnsTheCorrectTypeOfElementAtRequestedPosition() {

        GeologicalPattern pattern = GeologicalPattern.of(OPEN, TREE, TREE, OPEN);

        SoftAssertions softly = new SoftAssertions();
        assertThat(pattern.elementAt(1)).isEqualTo(OPEN);
        assertThat(pattern.elementAt(2)).isEqualTo(TREE);
        assertThat(pattern.elementAt(3)).isEqualTo(TREE);
        assertThat(pattern.elementAt(4)).isEqualTo(OPEN);
        assertThat(pattern.elementAt(5)).isEqualTo(OPEN);
        assertThat(pattern.elementAt(6)).isEqualTo(TREE);
        assertThat(pattern.elementAt(7)).isEqualTo(TREE);
        assertThat(pattern.elementAt(8)).isEqualTo(OPEN);
        assertThat(pattern.elementAt(9)).isEqualTo(OPEN);
        assertThat(pattern.elementAt(10)).isEqualTo(TREE);
        assertThat(pattern.elementAt(11)).isEqualTo(TREE);
        assertThat(pattern.elementAt(12)).isEqualTo(OPEN);

        softly.assertAll();
    }

    @Test
    void canParseAGeologicalPattern() {
        assertThat(GeologicalPattern.of(".##.")).isEqualTo(GeologicalPattern.of(OPEN, TREE, TREE, OPEN));
    }

}
