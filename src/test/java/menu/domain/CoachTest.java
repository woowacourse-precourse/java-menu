package menu.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;


class CoachTest {

    @DisplayName("코치 이름이 2자 이하, 4자 이상인 경우 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"민", "김이박최신"})
    void createWrongNameSize(String name) {
        assertThatThrownBy(() -> new Coach(name, new ArrayList<>()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("추천하지 않은 메뉴는 추천할 수 있다.")
    @Test
    void createNotRecommendedMenu() {
        // given
        Menu menu1 = new Menu("햄버거");
        Menu menu2 = new Menu("파스타");
        Coach coach = new Coach("포비", new ArrayList<>());
        coach.addMenu(menu1);

        // when, then
        assertThat(coach.hasNotSameMenu(menu2)).isEqualTo(true);
    }

    @DisplayName("이미 추천한 메뉴는 더 이상 추천할 수 없다.")
    @Test
    void createRecommendedMenu() {
        // given
        Menu menu = new Menu("햄버거");
        Menu recommendMenu = new Menu("햄버거");
        Coach coach = new Coach("포비", new ArrayList<>());
        coach.addMenu(menu);

        // when, then
        assertThat(coach.hasNotSameMenu(recommendMenu)).isEqualTo(false);
    }

    @DisplayName("먹지 못하는 메뉴는 추천할 수 없다.")
    @Test
    void createBanMenu() {
        // given
        Menu banMenu = new Menu("햄버거");
        Coach coach = new Coach("포비", List.of(banMenu));

        // when, then
        assertThat(coach.canEat(banMenu)).isEqualTo(false);
    }

    @DisplayName("먹을 수 있는 메뉴는 추천할 수 있다.")
    @Test
    void createRecommendMenu() {
        // given
        Menu banMenu = new Menu("햄버거");
        Menu recomMenu = new Menu("치킨");
        Coach coach = new Coach("포비", List.of(banMenu));

        // when, then
        assertThat(coach.canEat(recomMenu)).isEqualTo(true);
    }
}