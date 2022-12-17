package menu.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CoachTest {

    private static final String EXCEPTION_MESSAGE_PREFIX = "[ERROR]";

    @ParameterizedTest(name = "코치의 이름 수가 틀리면 예외 발생 테스트 - 입력: {0}")
    @ValueSource(strings = {"일", "일이삼사오육"})
    void nameLengthExceptionTest(String name) {
        assertThatThrownBy(() -> new Coach(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(EXCEPTION_MESSAGE_PREFIX);
    }

    private Coach makeBasicCoach() {
        Coach coach = new Coach("테스트");
        coach.addUneatableFoods(List.of("김밥"));
        coach.addFood(Day.MONDAY, "뇨끼");
        coach.addFood(Day.TUESDAY, "탕수육");

        return coach;
    }

    @ParameterizedTest(name = "못먹는 음식 테스트 - 먹을 수 있는 음식인가? {1}")
    @CsvSource(value = {"김밥,false", "뇨끼,true"})
    void uneatableFoodTest(String food, boolean expectedResult) {
        Coach coach = makeBasicCoach();
        boolean actualResult = coach.isEatable(food);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @CsvSource(value = {"뇨끼,true", "불고기,false"})
    void isEatBeforeTest(String food, boolean expectedResult) {
        Coach coach = makeBasicCoach();
        boolean actualResult = coach.isEatBefore(food);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

}