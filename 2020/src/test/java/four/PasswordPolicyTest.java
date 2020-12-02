package four;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PasswordPolicyTest {

    @Test
    void notValidIfCharacterNotAtAnyOfTheTwoPlaces() {
        assertThat(PasswordPolicy.of('b', 1, 3).test("cdefg")).isFalse();
    }

    @Test
    void validIfCharacterOnlyAtFirstLocation() {
        assertThat(PasswordPolicy.of('a', 1, 3).test("abcde")).isTrue();
    }

    @Test
    void validIfCharacterOnlyAtSecondLocation() {
        assertThat(PasswordPolicy.of('a', 1, 3).test("cbade")).isTrue();
    }

    @Test
    void invalidIfCharacterAtBothLocations() {
        assertThat(PasswordPolicy.of('c', 2, 9).test("ccccccccc")).isFalse();
    }

    @Test
    void ignoredIfFirstPositionIsLargerThanLengthOfPassword() {
        assertThat(PasswordPolicy.of('c', 10, 9).test("ccccccccc")).isFalse();
    }

    @Test
    void ignoredIfSecondPositionIsLargerThanLengthOfPassword() {
        assertThat(PasswordPolicy.of('c', 2, 19).test("ccccccccc")).isFalse();
    }

}
