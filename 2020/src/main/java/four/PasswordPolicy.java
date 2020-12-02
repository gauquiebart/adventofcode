package four;

import shared.ValueObject;

import java.util.function.Predicate;

class PasswordPolicy extends ValueObject implements Predicate<String> {

    private final char allowedCharacter;
    private final int firstPositionToCheckForAllowedCharacter;
    private final int secondPositionToCheckForAllowedCharacter;

    private PasswordPolicy(char allowedCharacter, int firstPositionToCheckForAllowedCharacter, int secondPositionToCheckForAllowedCharacter) {
        this.allowedCharacter = allowedCharacter;
        this.firstPositionToCheckForAllowedCharacter = firstPositionToCheckForAllowedCharacter;
        this.secondPositionToCheckForAllowedCharacter = secondPositionToCheckForAllowedCharacter;
    }

    static PasswordPolicy of(char allowedCharacter, int firstPositionToCheckForAllowedCharacter, int secondPositionToCheckForAllowedCharacter) {
        return new PasswordPolicy(allowedCharacter, firstPositionToCheckForAllowedCharacter, secondPositionToCheckForAllowedCharacter);
    }

    @Override
    public boolean test(String password) {
        return (firstPositionToCheckForAllowedCharacter > password.length() ||
                        password.charAt(firstPositionToCheckForAllowedCharacter - 1) == allowedCharacter)
                 ^ (secondPositionToCheckForAllowedCharacter > password.length() ||
                        password.charAt(secondPositionToCheckForAllowedCharacter - 1) == allowedCharacter);
    }
}
