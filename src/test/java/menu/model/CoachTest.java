package menu.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CoachTest {
    Coach coach;

    @BeforeEach
    void initCoach() {
        coach = new Coach("JJ");

        List<String> addMenu = Arrays.asList("김밥", "떡볶이");
        List<String> hateMenu = Arrays.asList("가츠동", "파인애플 볶음밥");

        for (String menu : addMenu) {
            coach.addSelectMenu(menu);
        }
        coach.addHateMenus(new HateMenu(hateMenu));
    }

    @DisplayName("이름 가져오기 테스트")
    @Test
    void getNameTest() {
        assertThat(coach.getName()).isEqualTo("JJ");
    }

    @DisplayName("선택 메뉴 가져오기 테스트")
    @Test
    void getSelectMenuTest() {
        assertThat(coach.getSelectMenu()).isEqualTo(Arrays.asList("JJ", "김밥", "떡볶이"));
    }

    @DisplayName("메뉴가 존재하는지 확인하기 테스트 - 존재하는 경우")
    @ValueSource(strings = {"김밥", "떡볶이"})
    @ParameterizedTest
    void isAlreadyExistMenuTest(String menu) {
        assertThat(coach.isAlreadyExistMenu(menu)).isTrue();
    }

    @DisplayName("메뉴가 존재하는지 확인하기 테스트 - 존재하지 않는 경우")
    @ValueSource(strings = {"비빔밥", "오니기리", "마파두부", "쌀국수", "스파게티"})
    @ParameterizedTest
    void isNotAlreadyExistMenuTest(String menu) {
        assertThat(coach.isAlreadyExistMenu(menu)).isFalse();
    }

    @DisplayName("싫어하는 메뉴인지 확인하기 테스트 - 싫어하는 메뉴인 경우")
    @ValueSource(strings = {"가츠동", "파인애플 볶음밥"})
    @ParameterizedTest
    void isHateMenuTest(String menu) {
        assertThat(coach.isHateMenu(menu)).isTrue();
    }

    @DisplayName("싫어하는 메뉴인지 확인하기 테스트 - 싫어지 않는 메뉴인 경우")
    @ValueSource(strings = {"비빔밥", "오니기리", "마파두부", "쌀국수", "스파게티"})
    @ParameterizedTest
    void isNotHateMenuTest(String menu) {
        assertThat(coach.isHateMenu(menu)).isFalse();
    }
}
