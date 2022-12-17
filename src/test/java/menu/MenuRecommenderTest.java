package menu;

import constant.Category;
import constant.Week;
import menu.domain.Coach;
import menu.domain.MenuRecommender;
import org.junit.jupiter.api.Test;
import repository.MenuForWeekRepository;

import java.util.LinkedHashMap;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class MenuRecommenderTest {
    @Test
    public void testMenuRecommender_못먹는메뉴미포함() {
        Coach coach1 = new Coach("승원");
        Coach coach2 = new Coach("자인");
        coach1.addHateFoodList(List.of("김치찌개", "김밥", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음"));
        coach2.addHateFoodList(List.of("김치찌개", "김밥", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음"));
        List<Coach> coaches = List.of(new Coach("승원"), new Coach("자인"));
        MenuForWeekRepository.initializeCoaches(coaches);
        MenuRecommender.recommendMenus(coaches);
        LinkedHashMap<Coach, List<String>> result = MenuForWeekRepository.getMenuResult();
        for (Coach coach : result.keySet()) {
            assertThat(
                    result.get(coach).stream().anyMatch(menu -> coach.isHateFood(menu))
            ).isFalse();
        }
    }

    @Test
    public void testMenuRecommender_카테고리중복아님테스트() {
        List<Coach> coaches = List.of(new Coach("승원"), new Coach("자인"));
        MenuForWeekRepository.initializeCoaches(coaches);
        MenuRecommender.recommendMenus(coaches);
        LinkedHashMap<Week, Category> result = MenuForWeekRepository.getCategoriesPerWeek();
        int sameCategoryCounts = (int) result.values().stream()
                .filter(category -> result.values().equals(category))
                .count();
        assertThat(sameCategoryCounts > 2).isFalse();
    }
}