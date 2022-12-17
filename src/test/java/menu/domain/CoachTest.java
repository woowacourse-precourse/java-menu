package menu.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("Coach")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@SuppressWarnings("NonAsciiCharacters")
class CoachTest {

    @ParameterizedTest
    @ValueSource(strings = {"멍", "다섯글자임"})
    void 생성자는_코치명의_길이가_2와_4_사이가_아닌경우_IllegalArgumentException을_던진다(String name) {
        Assertions.assertThatThrownBy(() -> new Coach(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("코치님의 이름은 2 ~ 4글자여야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"코치", "코치명", "코치명임"})
    void 생성자는_코치명의_길이가_2와_4_사이인_경우_예외를_던지지_않는다(String name) {
        Assertions.assertThatNoException().isThrownBy(() -> new Coach(name));
    }

    @Test
    void addInvalidMenus_메서드는_못먹는_모든_음식을_추가한다() {
        Coach coach = new Coach("코치");

        coach.addInvalidMenus(List.of(new Menu("음식")));

        assertThat(coach.isInvalidMenu(new Menu("음식"))).isTrue();
    }

    @Test
    void addRecommendMenu_메서드는_추천하는_음식을_추가한다() {
        Coach coach = new Coach("코치");

        coach.addRecommendMenu(new Menu("음식"));

        assertThat(coach.getRecommendMenuNames()).containsExactly("음식");
    }

    @Test
    void isInvalidMenu_메서드는_입력값이_못먹는_음식이나_이미_추천받은_음식이라면_true를_반환한다() {
        Coach coach = new Coach("코치");
        coach.addInvalidMenus(List.of(new Menu("음식")));

        boolean result = coach.isInvalidMenu(new Menu("음식"));

        assertThat(result).isTrue();
    }
}
