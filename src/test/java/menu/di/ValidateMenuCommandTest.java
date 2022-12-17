package menu.di;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("ValidateMenuCommand 클래스")
@DisplayNameGeneration(ReplaceUnderscores.class)
public class ValidateMenuCommandTest {

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"안녕,", "헬로우,123"})
    void ValidateMenuCommand_객체는_생성시_잘못된_값이_들어오면_IEA_예외(String input) {
        assertThatThrownBy(() -> new ValidateMenuCommand(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
