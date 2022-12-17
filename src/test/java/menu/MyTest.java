package menu;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import menu.Domain.Coach;

public class MyTest {
    @DisplayName("Coach 클래스 기능 Test")
    @Nested
    class CoachTest {
        @DisplayName("메뉴 추가")
        @Test
        void addMenuTest() {
            Coach coach = new Coach("test");
            String unfavoredMenu = "우동";
            coach.addMenu(unfavoredMenu);
            assertThat(coach.getMenus().get(0)).isEqualTo("우동");
        }

        @DisplayName("같은 메뉴가 있는지 확인")
        @Test
        void hasSameMenuTest() {
            Coach coach = new Coach("test");
            coach.addMenu("우동");
            coach.addMenu("우동");
            assertThat(coach.hasSameMenu()).isEqualTo(true);
        }

        @DisplayName("clear")
        @Test
        void clearTest() {
            Coach coach = new Coach("test");
            coach.addMenu("우동");
            coach.clearMenu();
            assertThat(coach.getMenus().size()).isEqualTo(0);
        }
    }
}
