package four;

import org.junit.jupiter.api.Test;

import static four.PassportElementType.*;
import static org.assertj.core.api.Assertions.assertThat;

class PassportElementTypeTest {

    @Test
    void birthYearIsValidIf4digitsAndAtLeast1920ButAtMost2002() {
        assertThat(BIRTH_YEAR.isValid("1919")).isFalse();
        assertThat(BIRTH_YEAR.isValid("1920")).isTrue();
        assertThat(BIRTH_YEAR.isValid("2002")).isTrue();
        assertThat(BIRTH_YEAR.isValid("2003")).isFalse();
        assertThat(BIRTH_YEAR.isValid("109")).isFalse();
        assertThat(BIRTH_YEAR.isValid("10999")).isFalse();
        assertThat(BIRTH_YEAR.isValid("abc")).isFalse();
    }

    @Test
    void issueYearIsValidIf4digitsAndAtLeast2010ButAtMost2020() {
        assertThat(ISSUE_YEAR.isValid("2009")).isFalse();
        assertThat(ISSUE_YEAR.isValid("2010")).isTrue();
        assertThat(ISSUE_YEAR.isValid("2020")).isTrue();
        assertThat(ISSUE_YEAR.isValid("2021")).isFalse();
        assertThat(ISSUE_YEAR.isValid("109")).isFalse();
        assertThat(ISSUE_YEAR.isValid("10999")).isFalse();
        assertThat(ISSUE_YEAR.isValid("abc")).isFalse();
    }

    @Test
    void expirationYearIsValidIf4digitsAndAtLeast2020ButAtMost2030() {
        assertThat(EXPIRATION_YEAR.isValid("2019")).isFalse();
        assertThat(EXPIRATION_YEAR.isValid("2020")).isTrue();
        assertThat(EXPIRATION_YEAR.isValid("2030")).isTrue();
        assertThat(EXPIRATION_YEAR.isValid("2031")).isFalse();
        assertThat(EXPIRATION_YEAR.isValid("109")).isFalse();
        assertThat(EXPIRATION_YEAR.isValid("10999")).isFalse();
        assertThat(EXPIRATION_YEAR.isValid("abc")).isFalse();
    }

    @Test
    void heightIsValidIfcmAndAtLeast150ButAtMost193() {
        assertThat(HEIGHT.isValid("149cm")).isFalse();
        assertThat(HEIGHT.isValid("150cm")).isTrue();
        assertThat(HEIGHT.isValid("193cm")).isTrue();
        assertThat(HEIGHT.isValid("194cm")).isFalse();
        assertThat(HEIGHT.isValid("150kjk")).isFalse();
    }

    @Test
    void heightIsValidIfinAndAtLeast59ButAtMost76() {
        assertThat(HEIGHT.isValid("58in")).isFalse();
        assertThat(HEIGHT.isValid("59in")).isTrue();
        assertThat(HEIGHT.isValid("76in")).isTrue();
        assertThat(HEIGHT.isValid("77in")).isFalse();
        assertThat(HEIGHT.isValid("abc")).isFalse();
    }

    @Test
    void hairColorIsValidIfDashAnd6digitsOrCharacters() {
        assertThat(HAIR_COLOR.isValid("abdwdd")).isFalse();
        assertThat(HAIR_COLOR.isValid("#abcde")).isFalse();
        assertThat(HAIR_COLOR.isValid("#abcded")).isTrue();
        assertThat(HAIR_COLOR.isValid("#abcde2")).isTrue();
        assertThat(HAIR_COLOR.isValid("#a3cde2")).isTrue();
        assertThat(HAIR_COLOR.isValid("#A3CDE2")).isFalse();
        assertThat(HAIR_COLOR.isValid("#a3cde_")).isFalse();
        assertThat(HAIR_COLOR.isValid("#a3cde25")).isFalse();
    }

    @Test
    void eyeColorIsValidIfOneOfSpecificColors() {
        assertThat(EYE_COLOR.isValid("amb")).isTrue();
        assertThat(EYE_COLOR.isValid("blu")).isTrue();
        assertThat(EYE_COLOR.isValid("brn")).isTrue();
        assertThat(EYE_COLOR.isValid("gry")).isTrue();
        assertThat(EYE_COLOR.isValid("grn")).isTrue();
        assertThat(EYE_COLOR.isValid("hzl")).isTrue();
        assertThat(EYE_COLOR.isValid("oth")).isTrue();
        assertThat(EYE_COLOR.isValid("jko")).isFalse();
    }

    @Test
    void passportIdIsValidIfNineDigitNumber() {
        assertThat(PASSPORT_ID.isValid("01234567")).isFalse();
        assertThat(PASSPORT_ID.isValid("012345678")).isTrue();
        assertThat(PASSPORT_ID.isValid("0123456789")).isFalse();
        assertThat(PASSPORT_ID.isValid("abdjklkj")).isFalse();
    }

    @Test
    void countryIdIsValid() {
        assertThat(COUNTRY_ID.isValid("abc")).isTrue();
    }

}
