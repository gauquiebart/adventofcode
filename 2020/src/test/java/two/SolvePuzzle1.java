package two;

import org.junit.jupiter.api.Test;
import shared.ValueObject;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.stream;
import static org.assertj.core.api.Assertions.assertThat;
import static shared.Files.linesOf;

public class SolvePuzzle1 {

    @Test
    void countNumberOfPasswordsThatMatchCorporatePolicy() {
        Stream<TestCase> passwordsWithPasswordPolicyies =
                linesOf("two/input.txt")
                .map(line ->
                {
                    List<String> passwordAndPasswordPolicy =
                            stream(line.split("((\\s+)|-|:)"))
                                    .filter(s -> !s.isEmpty())
                                    .map(String::trim)
                                    .collect(Collectors.toList());

                    return new TestCase(passwordAndPasswordPolicy.get(3),
                            PasswordPolicy1.of(passwordAndPasswordPolicy.get(2).charAt(0),
                                    Integer.parseInt(passwordAndPasswordPolicy.get(0)),
                                    Integer.parseInt(passwordAndPasswordPolicy.get(1))));
                });

        assertThat(passwordsWithPasswordPolicyies
                .filter(tc -> tc.passwordPolicy1.test(tc.password)).count()).isEqualTo(614);
    }

    private static class TestCase extends ValueObject {
        String password;
        PasswordPolicy1 passwordPolicy1;

        public TestCase(String password, PasswordPolicy1 passwordPolicy1) {
            this.password = password;
            this.passwordPolicy1 = passwordPolicy1;
        }

        @Override
        public String toString() {
            return "TestCase{" +
                    "password='" + password + '\'' +
                    ", passwordPolicy=" + passwordPolicy1 +
                    '}';
        }
    }
}
