package menu.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class WeeklyRecommendCategoryTest {

    @DisplayName("일주일 카테고리는 정해진 정해진 요일 만큼만 생성 되어야 한다.")
    @ParameterizedTest
    @MethodSource("generatedIdx")
    void validateHatesFood(List<Integer> idxs) {
        assertThatThrownBy(() -> {
            WeeklyRecommendCategory weeklyCategory = new WeeklyRecommendCategory(idxs);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> generatedIdx() {
        return Stream.of(
                Arguments.of(Arrays.asList(1)),
                Arguments.of(Arrays.asList(1,2)),
                Arguments.of(Arrays.asList(1,2,3,4,5,1))
        );
    }
}