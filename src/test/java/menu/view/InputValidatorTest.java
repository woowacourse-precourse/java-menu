package menu.view;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class InputValidatorTest {

    InputValidator inputValidator = new InputValidator();

    @ParameterizedTest
    @CsvSource({"한", "식일식중식"})
    void validateCoachNameTest(String coachName) {
        assertThatThrownBy(() -> inputValidator.validateCoachName(coachName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("코치 이름은 2글자 이상 4글자 이하입니다.");
    }

    @Test
    void validateCoachNamesLength() {
        List<String> coachNames = List.of("토미");
        assertThatThrownBy(() -> inputValidator.validateCoachNamesLength(coachNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("코치는 2명 이상 5명 이하입니다.");
    }

    @Test
    void validateCanNotEatMenusLengthTest() {
        List<String> canNotEatMenus = List.of("뇨끼", "월날쌈", "마파두부");
        assertThatThrownBy(() -> inputValidator.validateCanNotEatMenusLength(canNotEatMenus))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("못 먹는 메뉴는 2개까지만 가능합니다.");
    }

    @ParameterizedTest
    @CsvSource({"샥스핀", "똥냠꿍"})
    void validateCanNotEatMenuTest(String menuName) {
        assertThatThrownBy(() -> inputValidator.validateCanNotEatMenu(menuName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("카테고리에 존재하지 않는 메뉴입니다.");
    }

    @ParameterizedTest
    @CsvSource({"규동", "김치찌개", "라자냐"})
    void validateCanNotEatMenu_메서드는_카테고리에_존재하는_메뉴에_대해서는_예외를_발생시키지_않는다(String menuName) {
        assertThatCode(() -> inputValidator.validateCanNotEatMenu(menuName))
                .doesNotThrowAnyException();
    }
}