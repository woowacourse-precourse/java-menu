package menu.domain.vo;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import menu.domain.vo.Name;

public class NameTest {

    @Test
    void 이름은_2글자이상_4글자이하이다() {
        assertThatNoException().isThrownBy(() -> new Name("123"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"n", "엄청긴이름"})
    void 잘못된_길이는_오류를_던진다(String name) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Name(name));
    }

}
