package five;

import shared.ValueObject;

import java.util.List;
import java.util.stream.Collectors;

class SeatingPosition {

    private final String encoded;

    private SeatingPosition(String encoded) {
        this.encoded = encoded;
    }

    static SeatingPosition of(String encoded) {
        return new SeatingPosition(encoded);
    }

    public int row() {
        List<Boolean> binaryStream =
                encoded
                        .substring(0, 7)
                        .chars()
                        .mapToObj(c -> (char)c)
                        .map(c -> c == 'F')
                        .collect(Collectors.toList());


        Interval resultingInterval = binaryStream.stream().reduce(Interval.of(0, 127), Interval::restrict, ((interval, interval2) -> interval2));

        return resultingInterval.upper;
    }

    public int column() {
        List<Boolean> binaryStream =
                encoded
                        .substring(7, 10)
                        .chars()
                        .mapToObj(c -> (char)c)
                        .map(c -> c == 'L')
                        .collect(Collectors.toList());

        Interval resultingInterval = binaryStream.stream().reduce(Interval.of(0, 7), Interval::restrict, ((interval, interval2) -> interval2));

        return resultingInterval.upper;
    }

    public Integer seatID() {
        return 8 * row() + column();
    }

    private static class Interval extends ValueObject {
        private final int lower;
        private final int upper;

        private Interval(int lower, int upper) {
            this.lower = lower;
            this.upper = upper;
        }

        private static Interval of(int lower, int upper) {
            return new Interval(lower, upper);
        }

        public Interval restrict(Boolean forward) {
            if(forward) {
                return Interval.of(lower, lower + (upper - lower) / 2);
            } else {
                return Interval.of(lower + (upper - lower) / 2, upper);
            }
        }
    }
}
