package menu;

import menu.service.InputValidation;
import menu.service.MenuService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputTest {

    static MenuService menuService = new MenuService();
    static InputValidation inputValidation = new InputValidation();

    @DisplayName("코치이름 입력이 옳은가")
    @Test
    void 코치이름_입력_테스트(){
        String coachNameWithComma = "길일,길이,길삼,길사,길오,길육";
        String[] coachNames = coachNameWithComma.split(",");

        Assertions.assertThat(menuService.isValidCoachCount(coachNames.length)).isFalse();
    }

    @DisplayName("코치이름 입력이 옳은가")
    @Test
    void 코치이름_입력_테스트2(){
        String coachNameWithComma = "여섯글자래요,배민";
        String[] coachNames = coachNameWithComma.split(",");

        Assertions.assertThat(menuService.isValidCoachName(coachNames)).isFalse();
    }
}
