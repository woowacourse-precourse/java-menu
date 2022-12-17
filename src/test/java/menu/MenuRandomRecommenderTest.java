package menu;

import menu.domain.Coach;
import menu.domain.Menu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MenuRandomRecommenderTest {

    MenuRandomRecommender menuRandomRecommender;
    Coach coach;
    List<String> menu;

    @BeforeEach
    void init() {
        menuRandomRecommender = new MenuRandomRecommender();
        coach = new Coach("미성");
        coach.addRecommendedMenu("김밥");
        menu = Menu.KOREAN_MENU.getMenu();
    }

    @DisplayName("이미 추천된 메뉴는 다시 추천되지 않는다.")
    @Test
    void recommend() {
        String recommend;
        for (int i = 0; i < 5; i++) {
            recommend = menuRandomRecommender.recommend(menu, coach);
            assertThat(recommend).isNotEqualTo("김밥");
        }
    }
}