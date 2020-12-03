package two;

import shared.ValueObject;

import java.util.function.Predicate;

class PasswordPolicy1 extends ValueObject implements Predicate<String> {

    private final char allowedCharacter;
    private final int minimalAllowed;
    private final int atMostAllowed;

    private PasswordPolicy1(char allowedCharacter, int minimalAllowed, int atMostAllowed) {
        this.allowedCharacter = allowedCharacter;
        this.minimalAllowed = minimalAllowed;
        this.atMostAllowed = atMostAllowed;
    }

    static PasswordPolicy1 of(char allowedCharacter, int minimalAllowed, int atMostAllowed) {
        return new PasswordPolicy1(allowedCharacter, minimalAllowed, atMostAllowed);
    }

    @Override
    public boolean test(String aPassword) {
        long occurencesOfAllowedCharacter = aPassword.codePoints().mapToObj(c -> (char) c).filter(c -> c == allowedCharacter).count();
        return occurencesOfAllowedCharacter >= minimalAllowed
                && occurencesOfAllowedCharacter <= atMostAllowed;
    }
}
