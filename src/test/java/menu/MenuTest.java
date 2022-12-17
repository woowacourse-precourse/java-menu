package menu;

import menu.domain.Menu;
import menu.dto.CoachWeekMenu;
import menu.enums.FoodCategory;
import menu.vo.Coach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;
import static org.junit.jupiter.api.Assertions.fail;

public class MenuTest {

    @DisplayName("각 코치에게 한 주에 중복되지 않는 '메뉴' 를 추천하는지 확인")
    @Test
    void 중복되지_않는_메뉴_추천_테스트() {
        // given
        List<String> korFood = Arrays.asList("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음");
        Menu menu;

        Coach coach1 = new Coach("상민",Arrays.asList("김밥", "김치찌개"));
        Coach coach2 = new Coach("상훈",Arrays.asList("김밥", "김치찌개"));

        CoachWeekMenu coachWeekMenu1 = new CoachWeekMenu(coach1);
        CoachWeekMenu coachWeekMenu2 = new CoachWeekMenu(coach2);

        // when
        List<CoachWeekMenu> coachWeekMenus = new ArrayList<>();
        for (int i = 0 ; i < Constant.weekNum; i++) {
            menu = new Menu(FoodCategory.KOR);
            coachWeekMenus = menu.chooseShuffleMenu(Arrays.asList(coachWeekMenu1, coachWeekMenu2));
        }
        CoachWeekMenu coachWeekMenu = coachWeekMenus.get(0);
        Set<String> coachWeekMenuRemoveOverlap = coachWeekMenu.getEatMenus().stream()
                .collect(Collectors.toSet());

        // then
        assertThat(coachWeekMenu.getEatMenus().size()).isEqualTo(coachWeekMenuRemoveOverlap.size());
    }

}
