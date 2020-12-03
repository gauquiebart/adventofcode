package two;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PasswordPolicy1Test {

    @Test
    void notValidIfCharacterIsNotPresent() {
        assertThat(PasswordPolicy1.of('a', 1, 1).test("bc")).isFalse();
    }

    @Test
    void notValidIfCharacterLessPresentThanMinimumAllowed() {
        assertThat(PasswordPolicy1.of('a', 2, 1).test("abc")).isFalse();
    }

    @Test
    void validIfNumberOfOccurencesOfCharacterEqualToMinimumAllowed() {
        assertThat(PasswordPolicy1.of('a', 2, 3).test("abac")).isTrue();
    }

    @Test
    void validIfNumberOfOccurencesOfCharacterEqualToAtMostAllowed() {
        assertThat(PasswordPolicy1.of('a', 2, 3).test("abaca")).isTrue();
    }

    @Test
    void notValidIfNumberOfOccurencesOfCharacterMoreThanAtMostAllowed() {
        assertThat(PasswordPolicy1.of('a', 2, 3).test("abracadabra")).isFalse();
    }


}
