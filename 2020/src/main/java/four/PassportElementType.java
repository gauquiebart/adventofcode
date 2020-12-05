package four;

import static java.util.Arrays.stream;

public enum PassportElementType {

        BIRTH_YEAR("byr") {
            @Override
            boolean isValid(String value) {
                return inRange(value, 1920, 2002);
            }
        },
        ISSUE_YEAR("iyr") {
            @Override
            boolean isValid(String value) {
                return inRange(value, 2010, 2020);
            }
        },
        EXPIRATION_YEAR("eyr") {
            @Override
            boolean isValid(String value) {
                return inRange(value, 2020, 2030);
            }
        },
        HEIGHT("hgt") {
            @Override
            boolean isValid(String value) {
                if (value.matches("\\d{3}cm")) {
                    return inRange(value.split("cm")[0], 150, 193);
                }
                if (value.matches("\\d{2}in")) {
                    return inRange(value.split("in")[0], 59, 76);
                }
                return false;
            }
        },
        HAIR_COLOR("hcl") {
            @Override
            boolean isValid(String value) {
                return value.matches("#[a-z0-9]{6}");
            }
        },
        EYE_COLOR("ecl") {
            @Override
            boolean isValid(String value) {
                return value.matches("amb|blu|brn|gry|grn|hzl|oth");
            }
        },
        PASSPORT_ID("pid") {
            @Override
            boolean isValid(String value) {
                return value.matches("\\d{9}");
            }
        },
        COUNTRY_ID("cid") {
            @Override
            boolean isValid(String value) {
                return true;
            }
        };

    private final String stringRepresentation;

    PassportElementType(String stringRepresentation) {
        this.stringRepresentation = stringRepresentation;
    }

    abstract boolean isValid(String value);

    @Override
    public String toString() {
        return "" + name() + "/" + stringRepresentation;
    }

    private static boolean inRange(String value, int lowerBound, int upperBound) {
        try {
            int birthYear = Integer.parseInt(value);
            return birthYear >= lowerBound && birthYear <= upperBound;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    static PassportElementType of(String stringRepresentation) {
        return stream(values())
                .filter(pe -> pe.stringRepresentation.equals(stringRepresentation))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Could not find: "+  stringRepresentation));
    }


}
