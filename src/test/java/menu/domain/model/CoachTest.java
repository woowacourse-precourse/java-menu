package menu.domain.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.util.Lists.newArrayList;

class CoachTest {

    private Coach coach;

    @BeforeEach
    void setUp() {
        List<Menu> menus = List.of(new Menu(Category.JAPAN_FOOD, "우동"),
                new Menu(Category.JAPAN_FOOD, "스시")
        );
        coach = new Coach("토미", menus);
    }

    @Test
    void 못먹는_메뉴인지_판단하는기능_테스트() {
        boolean result = coach.canEat(new Menu(Category.JAPAN_FOOD, "우동"));
        assertThat(result).isFalse();
    }

    @Test
    void 이름_길이가_2_4가아니면_예외발생() {
        List<Menu> menus = List.of(new Menu(Category.JAPAN_FOOD, "우동"),
                new Menu(Category.JAPAN_FOOD, "스시")
        );
        assertThatThrownBy(() -> coach = new Coach("항", menus))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 이름은 최소 2글자, 최대 4글지 이어야합니다.");
    }

    @Test
    void 못먹는_메뉴가_0_2가아니면_예외발생() {
        List<Menu> menus = List.of(new Menu(Category.JAPAN_FOOD, "우동"),
                new Menu(Category.JAPAN_FOOD, "스시"),
                new Menu(Category.JAPAN_FOOD, "오니기리")
        );
        assertThatThrownBy(() -> coach = new Coach("토미", menus))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 못먹는 메뉴는 최소 0개 최대 2개이어야 합니다.");
    }

    @Test
    void 코치의_추천결과중_카테고리가2회이상인지_테스트() {
        List<Menu> menus = List.of(new Menu(Category.JAPAN_FOOD, "우동"),
                new Menu(Category.JAPAN_FOOD, "스시")
        );
        RecommendResult recommendResult =
                new RecommendResult(Day.MON, Category.JAPAN_FOOD, new Menu(Category.JAPAN_FOOD, "오니기리"));
        RecommendResult recommendResult2 =
                new RecommendResult(Day.TUE, Category.JAPAN_FOOD, new Menu(Category.JAPAN_FOOD, "오코노미야끼"));

        Coach tomi = new Coach("토미", menus, newArrayList(recommendResult, recommendResult2));

        boolean duplicateCategory = tomi.isDuplicateCategory(Category.JAPAN_FOOD, Day.WED);
        assertThat(duplicateCategory).isTrue();
    }

    @Test
    void 코치의_추천결과중_카테고리가2회이상인지_테스트2() {
        List<Menu> menus = List.of(new Menu(Category.JAPAN_FOOD, "우동"),
                new Menu(Category.JAPAN_FOOD, "스시")
        );
        RecommendResult recommendResult =
                new RecommendResult(Day.MON, Category.JAPAN_FOOD, new Menu(Category.JAPAN_FOOD, "오니기리"));
        RecommendResult recommendResult2 =
                new RecommendResult(Day.TUE, Category.JAPAN_FOOD, new Menu(Category.JAPAN_FOOD, "오코노미야끼"));

        Coach tomi = new Coach("토미", menus, newArrayList(recommendResult, recommendResult2));

        boolean duplicateCategory = tomi.isDuplicateCategory(Category.EUROPE_FOOD, Day.WED);
        assertThat(duplicateCategory).isFalse();
    }

    @Test
    void 이미_추천한_메뉴가있는지_검사() {
        List<Menu> menus = List.of(new Menu(Category.JAPAN_FOOD, "우동"),
                new Menu(Category.JAPAN_FOOD, "스시")
        );
        RecommendResult recommendResult =
                new RecommendResult(Day.MON, Category.JAPAN_FOOD, new Menu(Category.JAPAN_FOOD, "오니기리"));
        RecommendResult recommendResult2 =
                new RecommendResult(Day.TUE, Category.EUROPE_FOOD, new Menu(Category.JAPAN_FOOD, "피자"));

        Coach tomi = new Coach("토미", menus, newArrayList(recommendResult, recommendResult2));

        boolean duplicateCategory = tomi.isDuplicateMenu(new Menu(Category.JAPAN_FOOD, "오니기리"));
        assertThat(duplicateCategory).isTrue();
    }

    @Test
    void 이미_추천한_메뉴가있는지_검사2() {
        List<Menu> menus = List.of(new Menu(Category.JAPAN_FOOD, "우동"),
                new Menu(Category.JAPAN_FOOD, "스시")
        );
        RecommendResult recommendResult =
                new RecommendResult(Day.MON, Category.JAPAN_FOOD, new Menu(Category.JAPAN_FOOD, "오니기리"));
        RecommendResult recommendResult2 =
                new RecommendResult(Day.TUE, Category.EUROPE_FOOD, new Menu(Category.JAPAN_FOOD, "피자"));

        Coach tomi = new Coach("토미", menus, newArrayList(recommendResult, recommendResult2));

        boolean duplicateCategory = tomi.isDuplicateMenu(new Menu(Category.EUROPE_FOOD, "피자"));
        assertThat(duplicateCategory).isFalse();
    }
}