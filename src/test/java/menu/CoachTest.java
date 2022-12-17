package menu;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Menu;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CoachTest {

    @Test
    void 코치_생성_테스트() {
        String coachName = "kim";
        List<String> canNotEatMenus = List.of("마파두부", "탕수육");
        Coach coach = new Coach(coachName, canNotEatMenus);

        List<Menu> menus = List.of(new Menu("마파두부", Category.CHINESE_FOOD),
            new Menu("탕수육", Category.CHINESE_FOOD));

        assertThat(coach.getName()).isEqualTo("kim");
        assertThat(coach.getCanNotEatMenu()).isEqualTo(menus);
    }
}
