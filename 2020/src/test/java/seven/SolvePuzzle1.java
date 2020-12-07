package seven;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static seven.CanHoldBagSpecification.parseFrom;
import static shared.Files.readFileFromClasspath;

class SolvePuzzle1 {

    @Test
    void countNumberOfBagsThatCanContainTheShinyGoldBagInTestInput() {
        String content = readFileFromClasspath("seven/testinput.txt");

        Set<Bag> bagsThatCanHoldGoldShiny = bagsThatCanContainGoldShiny(content);


        assertThat(bagsThatCanHoldGoldShiny).contains(Bag.of("bright white"), Bag.of("muted yellow"), Bag.of("dark orange"), Bag.of("light red"));

    }

    @Test
    void countNumberOfBagsThatCanContainTheShinyGoldBagInInput() {
        String content = readFileFromClasspath("seven/input.txt");

        Set<Bag> bagsThatCanHoldGoldShiny = bagsThatCanContainGoldShiny(content);


        assertThat(bagsThatCanHoldGoldShiny).hasSize(208);

    }

    private Set<Bag> bagsThatCanContainGoldShiny(String content) {
        Set<CanHoldBagSpecification> canHoldBagSpecifications = Arrays.stream(content.split("\\n"))
                .map(str -> parseFrom(str))
                .collect(Collectors.toSet());

        Bag goldShiny = Bag.of("shiny gold");
        Set<Bag> bagsThatCanHoldGoldShiny = new HashSet<>();

        while(true) {
            Set<Bag> newBagsThanCanHoldShiny = canHoldBagSpecifications.stream()
                    .filter(spec ->
                        spec.canHold(goldShiny) ||
                        bagsThatCanHoldGoldShiny.stream()
                                .anyMatch(aBagThatCanHoldShiny -> spec.canHold(aBagThatCanHoldShiny)))
                    .map(spec -> spec.subject())
                    .collect(Collectors.toSet());
            boolean newBagsAdded = bagsThatCanHoldGoldShiny.addAll(newBagsThanCanHoldShiny);
            if (!newBagsAdded) {
                break;
            }
        }
        return bagsThatCanHoldGoldShiny;
    }


}
