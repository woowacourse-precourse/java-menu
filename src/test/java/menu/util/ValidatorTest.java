package menu.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidatorTest {
    static Stream<Arguments> getData(){
        return Stream.of(
                Arguments.of(List.of("나나")),
                Arguments.of(List.of("너너","니니","우우","으으","야야","응응"))
        );
    }

    static Stream<Arguments> getSecondData(){
        return Stream.of(
                Arguments.of(List.of("밥","빵","면")),
                Arguments.of(List.of("초코렛","젤리","사탕","과일"))
        );
    }

    @ParameterizedTest(name = "{0}의 이름 리스트는 최소 2명 최대 5명이 아니므로 예외 발생")
    @MethodSource("getData")
    @DisplayName("이름 리스트 사이즈 검증 로직")
    void 이믈_리스트_사이즈_검증(List<String> names){
        assertThatThrownBy(() -> Validator.validateCoachNamesSize(names))
                .isInstanceOf(IllegalArgumentException.class);
}

    @ParameterizedTest(name ="{0}의 이름은 최소 2자, 최대 4자가 아니므로 예외 발생")
    @ValueSource(strings = {"하","하하하하하"})
    @DisplayName("이름 길이 검증 로직")
    void 이름_길이_검증(String name){
        assertThatThrownBy(() -> Validator.validateCoachNameLength(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "{0}의 싫어하는 메뉴 리스트는 최소 0개 최대 2개가 아니므로 예외 발생")
    @MethodSource("getSecondData")
    @DisplayName("싫어하는 메뉴 사이즈 검증 로직")
    void 싫어하는_메뉴_사이즈(List<String> hateMenus){
        assertThatThrownBy(() -> Validator.validateHateMenusSize(hateMenus))
                .isInstanceOf(IllegalArgumentException.class);
    }

}