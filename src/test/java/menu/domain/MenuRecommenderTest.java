package menu.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import menu.dto.CoachDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MenuRecommenderTest {
    private MenuRecommender menuRecommender = new MenuRecommender(new TestShuffler());

    /*
        실제 프로그램에서는 잘 동작되나
        TestShuffler에서 셔플을 할 때, 입력값과 동일한 카테고리에 있는 음식리스트만 반환해야하나
        이를 못구현
     */
    @Test
    void recommend_메소드는_Group을_입력받아_코치들의_메뉴를_추천해준다() {
        Coach coach1 = new Coach("테스트1");
        Coach coach2 = new Coach("테스트2");
        Group group = new Group(List.of(coach1, coach2));
        group.addCoachCantEatMenus(new CoachDto(coach1.getName(), List.of(Menu.깐풍기, Menu.가츠동)));
        group.addCoachCantEatMenus(new CoachDto(coach2.getName(), List.of(Menu.규동, Menu.짬뽕)));

        menuRecommender.recommend(new TestNumberGenerator(), group);

        Map<Coach, RecommendResult> result = menuRecommender.getResult();
        RecommendResult recommendResult = result.get(coach1);
        List<Category> expectedCategory = new ArrayList<>();
        for (DayOfWeek dayOfWeek : DayOfWeek.values()) {
            Category category = recommendResult.getMenus(dayOfWeek).getCategory();
            expectedCategory.add(category);
        }
        Assertions.assertThat(expectedCategory)
                .contains(Category.values());
    }


    private static class TestNumberGenerator implements NumberGenerator {
        private final List<Integer> testCase = List.of(1, 2, 3, 4, 5);
        private int index = 0;

        @Override
        public int generate(int min, int max) {
            return testCase.get(index++);
        }
    }

    private static class TestShuffler implements Shuffler {
        List<String> menuNames;

        public TestShuffler() {
            menuNames = Arrays.stream(Menu.values())
                    .map(Menu::getName)
                    .collect(Collectors.toList());
        }

        @Override
        public List<String> shuffle(List<String> list) {
            //주어진 리스트와 동일한 카테고리에 있느 음식만 반환해야함
            return menuNames;
        }
    }
}