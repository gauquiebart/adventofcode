package five;


import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

class SeatingPositionTest {

    @Test
    void row() {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(SeatingPosition.of("FFFFFFFRLR").row()).isEqualTo(0);
        softly.assertThat(SeatingPosition.of("FBFBBFFRLR").row()).isEqualTo(44);
        softly.assertThat(SeatingPosition.of("BBBBBBBRLR").row()).isEqualTo(127);
        softly.assertAll();
    }

    @Test
    void column() {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(SeatingPosition.of("FFFFFFFLLL").column()).isEqualTo(0);
        softly.assertThat(SeatingPosition.of("FBFBBFFRLR").column()).isEqualTo(5);
        softly.assertThat(SeatingPosition.of("BBBBBBBRRR").column()).isEqualTo(7);
        softly.assertAll();
    }

    @Test
    void seatId() {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(SeatingPosition.of("FBFBBFFRLR").seatID()).isEqualTo(357);
        softly.assertThat(SeatingPosition.of("BFFFBBFRRR").seatID()).isEqualTo(567);
        softly.assertThat(SeatingPosition.of("FFFBBBFRRR").seatID()).isEqualTo(119);
        softly.assertThat(SeatingPosition.of("BBFFBBFRLL").seatID()).isEqualTo(820);
        softly.assertAll();
    }
}
