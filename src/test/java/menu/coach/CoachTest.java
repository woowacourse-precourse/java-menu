package menu.coach;

import menu.menu.Category;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CoachTest {

    @DisplayName("먹을 수 있는 메뉴가 전달된 경우 true, 아닌 경우 false")
    @Test
    void checkEat_1() {
        Coach coach = new Coach("한빈");
        coach.addFoodNotEat("스시");
        boolean check = coach.isEat("스시");
        assertThat(check).isFalse();

        check = coach.isEat("규동");
        assertThat(check).isTrue();
        coach.addfoodEaten("규동");

        check = coach.isEat("규동");
        assertThat(check).isFalse();

        check = coach.isEat("나시고렝");
        assertThat(check).isTrue();
        coach.addfoodEaten("나시고렝");
    }


    @DisplayName("메뉴 목록을 읽은 뒤 먹을 수 있는지 없는지 판단")
    @Test
    void checkEat_2() {
        Coach coach = new Coach("한빈");
        coach.addFoodNotEat("스시");

        // 한식
        String category = Category.get(2);
        List<String> menus = Category.getMenus(category);
        for (String menu: menus) {
            boolean check = coach.isEat(menu);
            assertThat(check).isTrue();
        }
    }
}
