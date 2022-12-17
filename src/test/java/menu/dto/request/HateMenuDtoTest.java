package menu.dto.request;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class HateMenuDtoTest {

    @DisplayName("객체 생성시")
    @Nested
    class create {

        @DisplayName("메뉴가 2개를 초과하면 예외를 반환한다.")
        @Test
        void test1() {
            assertThatIllegalArgumentException().isThrownBy(() -> new HateMenuDto(List.of("a","b","c")));
        }

        @DisplayName("메뉴가 2개를 이하면 정상적으로 생성한다.")
        @Test
        void test2() {
            assertThatNoException().isThrownBy(() -> new HateMenuDto(List.of("a")));
        }
    }

}