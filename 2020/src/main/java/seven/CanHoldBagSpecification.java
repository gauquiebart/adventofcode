package seven;

import shared.ValueObject;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class CanHoldBagSpecification extends ValueObject {

    static class CanHoldANumberOfBags extends ValueObject {
        private final Bag bag;
        private final Integer number;

        private CanHoldANumberOfBags(Bag bag, Integer number) {
            this.bag = bag;
            this.number = number;
        }

        static CanHoldANumberOfBags of(Bag bag, Integer number) {
            return new CanHoldANumberOfBags(bag, number);
        }
    }

    private final Bag subject;
    private final Set<CanHoldANumberOfBags> canHoldBags;

    private CanHoldBagSpecification(Bag subject, Set<CanHoldANumberOfBags> canHoldBags) {
        this.subject = subject;
        this.canHoldBags = new HashSet<>(canHoldBags);
    }

    static CanHoldBagSpecification of(Bag subject) {
        return new CanHoldBagSpecification(subject, new HashSet<>());
    }

    CanHoldBagSpecification canAlsoHold(CanHoldANumberOfBags otherBag) {
        Set<CanHoldANumberOfBags> allBagsSubjectCanHold = new HashSet<>(canHoldBags);
        allBagsSubjectCanHold.add(otherBag);
        return new CanHoldBagSpecification(subject, allBagsSubjectCanHold);
    }

    Bag subject() {
        return subject;
    }

    boolean canHold(Bag aBag) {
        return canHoldBags
                .stream().anyMatch(canHoldANumberOfBags -> aBag.equals(canHoldANumberOfBags.bag));
    }

    static CanHoldBagSpecification parseFrom(String str) {
        String subject = str.split(" bags contain ")[0];
        String canHolds = str.split(" bags contain ")[1];
        CanHoldBagSpecification result = of(Bag.of(subject));
        if(canHolds.equals("no other bags.")) {
            result = of(Bag.of(subject));
        } else {
            String[] otherBagsItCanHold = canHolds.replace(".", "").split(", ");
            Pattern pattern = Pattern.compile("(\\d+) (\\w+ \\w+) bag[s]{0,1}");
            for (String otherBag: otherBagsItCanHold) {
                Matcher matcher = pattern.matcher(otherBag);
                matcher.matches();
                result = result.canAlsoHold(CanHoldANumberOfBags.of(Bag.of(matcher.group(2)), Integer.parseInt(matcher.group(1))));
            }
        }
        return result;
    }
}
