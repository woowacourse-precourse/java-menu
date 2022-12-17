package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CoachNamesTest {
    @DisplayName("이름의 길이가 유효한지 검증한다")
    //given
    @ValueSource(strings = {"ㅇ,ㅁㄴ,ㅁㄴㅇㄹ,ㅁㄴ", "1,123,,12", "1243124,123,123"})
    @ParameterizedTest
    void invalidNameLength(String strings) {

        assertThatThrownBy(() -> {
            CoachNames coachNames = new CoachNames(strings);
        }).isInstanceOf(
            IllegalArgumentException.class);
    }

    @DisplayName("코치님들의 숫자가 유효한지 검증한다")
    //given
    @ValueSource(strings = {"ㅁㄴ", "1243124,123,126,1241,12"})
    @ParameterizedTest
    void invalidNumber(String strings) {

        assertThatThrownBy(() -> {
            CoachNames coachNames = new CoachNames(strings);
        }).isInstanceOf(
            IllegalArgumentException.class);
    }

    @DisplayName("이름이 중복되지 않았는지 검증한다.")
    //given
    @ValueSource(strings = {"ㄷㄷㅇ,ㅁㄴ,ㅁㄴㅇㄹ,ㅁㄴ"})
    @ParameterizedTest
    void duplicate(String strings) {

        assertThatThrownBy(() -> {
            CoachNames coachNames = new CoachNames(strings);
        }).isInstanceOf(
            IllegalArgumentException.class);
    }
}