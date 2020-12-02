package three;

import shared.ValueObject;

import java.util.Objects;
import java.util.function.Predicate;

class PasswordPolicy extends ValueObject implements Predicate<String> {

    private final char allowedCharacter;
    private final int minimalAllowed;
    private final int atMostAllowed;

    private PasswordPolicy(char allowedCharacter, int minimalAllowed, int atMostAllowed) {
        this.allowedCharacter = allowedCharacter;
        this.minimalAllowed = minimalAllowed;
        this.atMostAllowed = atMostAllowed;
    }

    static PasswordPolicy of(char allowedCharacter, int minimalAllowed, int atMostAllowed) {
        return new PasswordPolicy(allowedCharacter, minimalAllowed, atMostAllowed);
    }

    @Override
    public boolean test(String aPassword) {
        long occurencesOfAllowedCharacter = aPassword.codePoints().mapToObj(c -> (char) c).filter(c -> c == allowedCharacter).count();
        return occurencesOfAllowedCharacter >= minimalAllowed
                && occurencesOfAllowedCharacter <= atMostAllowed;
    }
}
