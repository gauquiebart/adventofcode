package two;

import shared.ValueObject;

import java.util.function.Predicate;

class PasswordPolicy2 extends ValueObject implements Predicate<String> {

    private final char allowedCharacter;
    private final int firstPositionToCheckForAllowedCharacter;
    private final int secondPositionToCheckForAllowedCharacter;

    private PasswordPolicy2(char allowedCharacter, int firstPositionToCheckForAllowedCharacter, int secondPositionToCheckForAllowedCharacter) {
        this.allowedCharacter = allowedCharacter;
        this.firstPositionToCheckForAllowedCharacter = firstPositionToCheckForAllowedCharacter;
        this.secondPositionToCheckForAllowedCharacter = secondPositionToCheckForAllowedCharacter;
    }

    static PasswordPolicy2 of(char allowedCharacter, int firstPositionToCheckForAllowedCharacter, int secondPositionToCheckForAllowedCharacter) {
        return new PasswordPolicy2(allowedCharacter, firstPositionToCheckForAllowedCharacter, secondPositionToCheckForAllowedCharacter);
    }

    @Override
    public boolean test(String password) {
        return (firstPositionToCheckForAllowedCharacter > password.length() ||
                        password.charAt(firstPositionToCheckForAllowedCharacter - 1) == allowedCharacter)
                 ^ (secondPositionToCheckForAllowedCharacter > password.length() ||
                        password.charAt(secondPositionToCheckForAllowedCharacter - 1) == allowedCharacter);
    }
}
