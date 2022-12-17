package menu.view.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static menu.constant.Constants.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class ValidatorsTest {

    @DisplayName("코치 이름의 길이가 2~4인 경우")
    @Test
    void test1() {
        List<String> input = List.of("포비", "일라이", "줄리안느");
        Throwable t = catchThrowable(() -> Validators.validateForInvalidRangeOfCoachName(input));

        assertThat(t).doesNotThrowAnyException();
    }

    @DisplayName("코치 이름의 길이가 2~4가 아닌 경우")
    @Test
    void test2() {
        List<String> input = List.of("포피", "줄리안느리");
        Throwable t = catchThrowable(() -> Validators.validateForInvalidRangeOfCoachName(input));

        assertThat(t).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_MESSAGE + COACH_NAME_INVALID_RANGE_ERROR_MESSAGE);
    }

    @DisplayName("코치 인원수 2,3,4,5")
    @ParameterizedTest
    @ValueSource(ints = {2, 3, 4, 5})
    void test3(int size) {
        Throwable t = catchThrowable(() -> Validators.validateForInvalidRangeOfCoachCount(size));
        assertThat(t).doesNotThrowAnyException();
    }


    @DisplayName("코치 인원수 1 이하")
    @Test
    void test4() {
        Throwable t = catchThrowable(() -> Validators.validateForInvalidRangeOfCoachCount(1));

        assertThat(t).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_MESSAGE + COACH_INVALID_RANGE_ERROR_MESSAGE_OVER_TWO);
    }

    @DisplayName("코치 인원수 6 이상")
    @Test
    void test5() {
        Throwable t = catchThrowable(() -> Validators.validateForInvalidRangeOfCoachCount(6));

        assertThat(t).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_MESSAGE + COACH_INVALID_RANGE_ERROR_MESSAGE_UNDER_FIVE);
    }

    @DisplayName("존재하는 음식이름 인 경우")
    @Test
    void test6() {
        List<String> list = List.of("규동", "김밥", "동파육", "프렌치 토스트");
        Throwable t = catchThrowable(() -> Validators.validateForFoodName(list));

        assertThat(t).doesNotThrowAnyException();
    }

    @DisplayName("존재하지 않는 음식이름 인 경우")
    void test7() {
        List<String> list = List.of("김치", "초밥", "오징어", "감자");
        Throwable t = catchThrowable(() -> Validators.validateForFoodName(list));

        assertThat(t).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_MESSAGE + INVALID_FOOD_NAME_ERROR_MESSAGE);
    }
}