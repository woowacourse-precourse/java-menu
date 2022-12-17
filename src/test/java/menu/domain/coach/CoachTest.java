package menu.domain.coach;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CoachTest {

    static Stream<Arguments> getData(){
        return Stream.of(
                Arguments.of(List.of("전","밥","고기"), "고기", false),
                Arguments.of(List.of("밥","빵"), "면", true)
                );
    }

    static Stream<Arguments> getSecondData(){
        return Stream.of(
                Arguments.of(List.of("전","밥","고기")),
                Arguments.of(List.of("밥","빵"))
        );
    }

    @ParameterizedTest(name="{0}의 이름은 최소 2자, 최대 4자라는 이름 길이 규칙에 위반되므로 에러 발생")
    @ValueSource(strings = {"나","너","아야어여요오"})
    @DisplayName("이름 길이 검증 로직")
    void 이름_길이_검증_예외(String name){
        assertThatThrownBy(() ->
                new Coach(name)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "{0}이 해당 코치가 싫어하는 음식이면, {1}의 canEat() 결과는 {2}")
    @MethodSource("getData")
    @DisplayName("canEat() 검증")
    void can_eat(List<String> hateMenu, String menu, boolean expected){
        Coach coach = new Coach("민주");
        coach.setHateMenuNames(hateMenu);
        boolean result = coach.canEat(menu);

        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest(name = "{0} 안의 음식을 updateAteMenuNames()하면 getAteMenuNames()의 결과는 {0}")
    @MethodSource("getSecondData")
    @DisplayName("set and get AteMenuNames()로직 검증")
    void ate_menu_names(List<String> ateMenus){
        Coach coach = new Coach("민주");
        for (String ateMenu : ateMenus) {
            coach.updateAteMenus(ateMenu);
        }
        List<String> result = coach.getAteMenuNames();
        assertThat(result).isEqualTo(ateMenus);
    }

}