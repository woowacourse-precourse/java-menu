package menu.dto.request;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import menu.domain.Coach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CoachNameDtoTest {

    @DisplayName("객체 생성시")
    @Nested
    class create {

        @DisplayName("이름이 2글자 미만 혹은 4글자 초과이면 예외를 반환한다.")
        @ValueSource(strings = {"a", "aaaaa"})
        @ParameterizedTest
        void test1(String wrongSizeName) {
            assertThatIllegalArgumentException().isThrownBy(() -> new CoachNameDto(wrongSizeName));
        }

        @DisplayName("이름이 2글자 이상 혹은 4글자 이하면 정상적으로 생성한다..")
        @ValueSource(strings = {"tw", "four"})
        @ParameterizedTest
        void test2(String rightSizeName) {
            assertThatNoException().isThrownBy(() -> new CoachNameDto(rightSizeName));
        }
    }

}