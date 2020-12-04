package four;

import static java.util.Arrays.stream;

public enum PassportElementType {

        BIRTH_YEAR("byr"){
            @Override
            boolean valid(String value) {
                return false;
            }
        },
        ISSUE_YEAR("iyr") {
            @Override
            boolean valid(String value) {
                return false;
            }
        },
        EXPIRATION_YEAR("eyr") {
            @Override
            boolean valid(String value) {
                return false;
            }
        },
        HEIGHT("hgt") {
            @Override
            boolean valid(String value) {
                return false;
            }
        },
        HAIR_COLOR("hcl") {
            @Override
            boolean valid(String value) {
                return false;
            }
        },
        EYE_COLOR("ecl") {
            @Override
            boolean valid(String value) {
                return false;
            }
        },
        PASSPORT_ID("pid") {
            @Override
            boolean valid(String value) {
                return false;
            }
        },
        COUNTRY_ID("cid") {
            @Override
            boolean valid(String value) {
                return false;
            }
        };

    private final String stringRepresentation;

    PassportElementType(String stringRepresentation) {
        this.stringRepresentation = stringRepresentation;
    }

    abstract boolean valid(String value);

    @Override
    public String toString() {
        return "" + name() + "/" + stringRepresentation;
    }

    static PassportElementType of(String stringRepresentation) {
        return stream(values())
                .filter(pe -> pe.stringRepresentation.equals(stringRepresentation))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Could not find: "+  stringRepresentation));
    }


}
