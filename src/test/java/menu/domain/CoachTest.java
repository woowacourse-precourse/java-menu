package menu.domain;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CoachTest {
    private static final String COACH_NAME = "테스트";
    Coach coach;

    @BeforeEach
    void initCoach() {
        coach = new Coach(COACH_NAME);
    }

    @Test
    void addCantEatMenus_메소드는_Coach가_못_먹는_메뉴를_추가해주는_메소드다() {
        List<Menu> menus = List.of(Menu.가츠동, Menu.뇨끼);
        coach.addCantEatMenus(menus);

        Assertions.assertThat(coach).extracting("cantEatMenus")
                .isEqualTo(menus);
    }

    @Test
    void addCantEatMenus_메소드에서_메뉴의_크기가_2보다_크면_에러를_반환한다() {
        List<Menu> menus = List.of(Menu.가츠동, Menu.뇨끼, Menu.규동);

        Assertions.assertThatThrownBy(() -> coach.addCantEatMenus(menus))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void isSameName_코치의_이름이_같은지_확인하는_메소드다() {
        Assertions.assertThat(coach.isSameName(COACH_NAME))
                .isTrue();
    }

    @Test
    void exceptCantEatMenus_메소드는_메뉴이름이_담긴_리스트를_입력값으로_주면_못먹는_음식을_제외한_리스트를_반환하는_메소드다() {
        List<Menu> cantEatMenu = List.of(Menu.가츠동, Menu.뇨끼);
        coach.addCantEatMenus(cantEatMenu);
        List<String> menus = new ArrayList<>();
        menus.add("깐풍기");
        menus.add("가츠동");
        menus.add("뇨끼");

        List<String> menuExceptCantEat = coach.exceptCantEatMenus(menus);

        Assertions.assertThat(menuExceptCantEat.size()).isEqualTo(1);
        Assertions.assertThat(menuExceptCantEat.get(0)).isEqualTo("깐풍기");
    }
}