package menu.repository;

import java.util.List;
import menu.domain.Coach;
import menu.message.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CoachesRepositoryTest {

    @DisplayName("코치 정상 찾기 테스트")
    @ParameterizedTest
    @CsvSource({"우테코", "붙고", "싶다"})
    void findByName_success(final String expectedName) {
        // given
        List<Coach> coaches = List.of(new Coach("우테코"), new Coach("붙고"), new Coach("싶다"));

        // when
        CoachesRepository.save(coaches);

        // then
        Assertions.assertThatNoException()
                .isThrownBy(() -> CoachesRepository.findByName(expectedName));
    }

    @DisplayName("코치 정상 찾기 예외 발생")
    @ParameterizedTest
    @CsvSource({"우테코", "붙고", "싶다"})
    void findByName_fail(final String expectedName) {
        // given
        List<Coach> coaches = List.of(new Coach("우코"), new Coach("고"), new Coach("다"));

        // when
        CoachesRepository.save(coaches);

        // then
        Assertions.assertThatThrownBy(() -> CoachesRepository.findByName(expectedName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NOT_EXISTS_COACH_NAME);
    }
}