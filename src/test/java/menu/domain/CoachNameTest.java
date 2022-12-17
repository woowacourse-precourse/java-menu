package menu.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("CoachName 클래스")
@DisplayNameGeneration(ReplaceUnderscores.class)
class CoachNameTest {

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"헬", "hello", "tobi"})
    void CoachName_클래스는_생성시_조건에_맞지않는_이름이_들어올_경우_IEA_예외를_반환한다(String input) {
        assertThatThrownBy(() -> new CoachName(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void CoachName_클래스는_생성시_조건에_맞는_이름이_들어올_경우_잘_생성된다() {
        assertThat(new CoachName("안녕").getName()).isEqualTo("안녕");
    }
}
