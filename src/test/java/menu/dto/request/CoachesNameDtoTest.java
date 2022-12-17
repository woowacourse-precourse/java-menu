package menu.dto.request;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CoachesNameDtoTest {


    @DisplayName("코치가 2명 미만이면 예외를 반환한다.")
    @Test
    void test1() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new CoachesNameDto(List.of(new CoachNameDto("hi"))));
    }

    @DisplayName("코치가 5명을 초과하면 예외를 반환한다.")
    @Test
    void test2() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new CoachesNameDto(
                        List.of(new CoachNameDto("hi1"),
                                new CoachNameDto("hi2"),
                                new CoachNameDto("hi3"),
                                new CoachNameDto("hi4"),
                                new CoachNameDto("hi5"),
                                new CoachNameDto("hi6"))));
    }

    @DisplayName("코치가 2명 이상 5명 이하면 정상적으로 생성한다..")
    @Test
    void test3() {
        assertThatNoException().isThrownBy(
                () -> new CoachesNameDto(
                        List.of(new CoachNameDto("hi1"),
                                new CoachNameDto("hi2"),
                                new CoachNameDto("hi3"),
                                new CoachNameDto("hi4"),
                                new CoachNameDto("hi5"))));
    }
}