package menu.domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CoachTest {

    @Test
    @DisplayName("코치가 먹지못하는 음식을 넣으면 true를 반환한다")
    void canNotEatTest() {
        //given
        Menu notEatMenu = new Menu("김치찌게");
        Coach coach = new Coach("짱구", List.of(notEatMenu));
        //when
        boolean actual = coach.canNotEat(notEatMenu);
        //then
        Assertions.assertThat(actual).isTrue();
    }
}
