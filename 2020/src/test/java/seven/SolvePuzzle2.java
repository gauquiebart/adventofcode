package seven;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static seven.CanHoldBagSpecification.parseFrom;
import static shared.Files.readFileFromClasspath;

class SolvePuzzle2 {

    @Test
    void countNumberOfBagsThatCanTheShinyGoldBagHoldsForTestInput() {
        String content = readFileFromClasspath("seven/testinput2.txt");

        Integer numberOfBagsThatShinyGoldHolds = numberOfBagsThatShinyGoldHolds(content);
        assertThat(numberOfBagsThatShinyGoldHolds).isEqualTo(126);
    }

    private Integer numberOfBagsThatShinyGoldHolds(String content) {
        Set<CanHoldBagSpecification> canHoldBagSpecifications = Arrays.stream(content.split("\\n"))
                .map(str -> parseFrom(str))
                .collect(Collectors.toSet());

        Bag goldShiny = Bag.of("shiny gold");

        => solve as tree

        return allCanHoldBagSpecifications.size();
    }
}
