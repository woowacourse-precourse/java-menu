package menu.di;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("ValidateNameCommand 클래스")
@DisplayNameGeneration(ReplaceUnderscores.class)
class ValidateNameCommandTest {

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"안녕,", "헬로우,123"})
    void ValidateNameCommand_객체는_생성시_잘못된_값이_들어오면_IEA_예외(String input) {
        assertThatThrownBy(() -> new ValidateNameCommand(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void ValidateNameCommand_객체는_생성시_적절한_값이_들어오면_잘_생성된다() {
        assertDoesNotThrow(() -> new ValidateMenuCommand("헬로우,사람,아님"));
    }

    @Test
    void getNames_메서드는_input_을_바탕으로_이름을_찾아준다() {
        assertThat(new ValidateMenuCommand("사람,아님").getMenus())
                .containsAll(List.of("사람", "아님"));
    }
}
