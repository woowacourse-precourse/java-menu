package menu.model;

import menu.repository.MenuRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static menu.model.MenuCategory.KOREA;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("코치와 관련된 테스트를 진행한다.")
class CoachTest {

    private static MenuRepository menuRepository;

    @BeforeEach
    void setup() {
        menuRepository = new MenuRepository();
    }

    @Test
    void 중복된_카테고리를_검증한다() {
        //given
        Coach coach = new Coach("포비");
        coach.addAlreadyEatFood(List.of("김치찌개", "비빔밥"));

        //when
        //then
        assertThatThrownBy(() -> coach.validateIfTooManyCategory(menuRepository.getMenus(KOREA), KOREA))
                .isInstanceOf(IllegalStateException.class);
    }
}