package five;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Comparator.comparing;
import static org.assertj.core.api.Assertions.assertThat;
import static shared.Files.linesOf;

class SolvePuzzle {

    @Test
    void highestSeatIDOnBoardingPasses() {
        int highestSeatID =
                linesOf("five/input.txt")
                .map(SeatingPosition::of)
                .max(comparing(SeatingPosition::seatID))
                .get().seatID();

        assertThat(highestSeatID).isEqualTo(888);
    }

    @Test
    void findMissingSeatID() {

        int lowestSeatID =
                linesOf("five/input.txt")
                        .map(SeatingPosition::of)
                        .min(comparing(SeatingPosition::seatID))
                        .get().seatID();
        int highestSeatID =
                linesOf("five/input.txt")
                        .map(SeatingPosition::of)
                        .max(comparing(SeatingPosition::seatID))
                        .get().seatID();

        assertThat(lowestSeatID).isEqualTo(89);
        assertThat(highestSeatID).isEqualTo(888);

        Set<Integer> allPossibleSeatIDs =
                IntStream.iterate(89, (seatID) -> seatID <= highestSeatID, (seatID) -> seatID+1)
                .boxed().collect(Collectors.toSet());

        Set<Integer> actualSeatIDs =
                linesOf("five/input.txt")
                    .map(SeatingPosition::of)
                    .map(SeatingPosition::seatID)
                    .collect(Collectors.toSet());

        allPossibleSeatIDs.removeAll(actualSeatIDs);

        assertThat(allPossibleSeatIDs).containsExactly(522);

    }


}
