package seven;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CanHoldBagSpecificationTest {

    @Test
    void canParse() {
        assertThat(CanHoldBagSpecification.parseFrom("light red bags contain 1 bright white bag, 2 muted yellow bags."))
                .isEqualTo(CanHoldBagSpecification.of(Bag.of("light red")).canAlsoHold(Bag.of("bright white")).canAlsoHold(Bag.of("muted yellow")));

        assertThat(CanHoldBagSpecification.parseFrom("faded blue bags contain no other bags."))
                .isEqualTo(CanHoldBagSpecification.of(Bag.of("faded blue")));
    }

}
