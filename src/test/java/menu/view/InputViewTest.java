package menu.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewTest {
    private static final InputView inputView = new InputView();

    @DisplayName("코치는 2명이상 5명 이하이다.")
    @ParameterizedTest
    @MethodSource("generatedNames")
    void validateNamesCount(List<String> names) {
        assertThatThrownBy(() -> {
            inputView.validateNames(names);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("코치이름의 길이는 2이상 4 이하여야 한다.")
    @ParameterizedTest
    @MethodSource("generatedNameLength")
    void validateNamesLength(List<String> names) {
        assertThatThrownBy(() -> {
            inputView.validateNames(names);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("싫어하는 음식으 0개이상 2개 이하이다.")
    @ParameterizedTest
    @MethodSource("generatedFood")
    void validateHatesFood(List<String> foods) {
        assertThatThrownBy(() -> {
            inputView.validateHatesFood(foods);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> generatedNames() {
        return Stream.of(
                Arguments.of(Arrays.asList("코구")),
                Arguments.of(Arrays.asList()),
                Arguments.of(Arrays.asList("코구", "코누", "고두", "코루", "코무", "코루"))
        );
    }

    static Stream<Arguments> generatedNameLength() {
        return Stream.of(
                Arguments.of(Arrays.asList("코구루이코")),
                Arguments.of(Arrays.asList("코"))
        );
    }

    static Stream<Arguments> generatedFood() {
        return Stream.of(
                Arguments.of(Arrays.asList("분짜", "짜장면", "뇨끼"))
        );
    }
}