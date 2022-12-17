package menu;

import menu.domain.Menu;
import menu.dto.CoachWeekMenu;
import menu.enums.FoodCategory;
import menu.vo.Coach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;
import static org.junit.jupiter.api.Assertions.fail;

public class MenuTest {
    @DisplayName("보여지는 테스트 설명")
    @Test
    void 테스트_이름() {
        // given

        // TODO: 프로그램 구현
        List<String> korFood = Arrays.asList("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음");
        Menu menu = new Menu(FoodCategory.KOR);

        Coach coach1 = new Coach("상민",Arrays.asList("김밥", "김치찌개"));
        Coach coach2 = new Coach("상훈",Arrays.asList("김밥", "김치찌개"));

        CoachWeekMenu coachWeekMenu1 = new CoachWeekMenu(coach1);
        CoachWeekMenu coachWeekMenu2 = new CoachWeekMenu(coach2);

        for (int i = 0; i < 3 ; i++) {
            List<CoachWeekMenu> coachWeekMenus = menu.chooseShuffleMenu(Arrays.asList(coachWeekMenu1, coachWeekMenu2));

            for (CoachWeekMenu coachWeekMenu : coachWeekMenus) {
                System.out.println(coachWeekMenu.getCoach());
                System.out.println(coachWeekMenu.getEatMenus());
            }
        }

        // when

        // then

    }
}
