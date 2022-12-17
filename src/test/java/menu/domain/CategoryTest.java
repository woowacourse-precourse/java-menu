package menu.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CategoryTest {
    
    @Test
    @DisplayName("존재하지 않는 음식 에러 테스트")
    void 예외_테스트1() {
        assertThatThrownBy(() -> Category.validateMenu("빵"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
