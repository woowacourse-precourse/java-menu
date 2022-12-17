package menu.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;

@DisplayName("NullValidator 클래스")
@DisplayNameGeneration(ReplaceUnderscores.class)
class NullValidatorTest {

    @Test
    void throwIfNull_메서드는_null_이_들어오면_IEA_예외를_발생시킨다() {
        assertThatThrownBy(() -> NullValidator.throwIfNull(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void throwIfNull_메서드는_null_이_아니라면_아무것도_하지_않는다() {
        assertDoesNotThrow(() -> NullValidator.throwIfNull("not null"));
    }
}
