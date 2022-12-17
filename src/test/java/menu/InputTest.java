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

    @DisplayName("코치의 못 먹는 메뉴 입력이 옳은가")
    @Test
    void 코치_못먹는메뉴_입력_테스트1(){
        String canNotEatMenusWithComma = "하나,둘,셋,넷";
        String[] canNotEatMenus = canNotEatMenusWithComma.split(",");

        Assertions.assertThat(inputValidation.isValidCoachCanNotEatMenuCount(canNotEatMenus.length)).isFalse();
    }

    @DisplayName("코치의 못 먹는 메뉴 입력이 옳은가")
    @Test
    void 코치_못먹는메뉴_입력_테스트2(){
        String canNotEatMenusWithComma = "하나,둘";
        String[] canNotEatMenus = canNotEatMenusWithComma.split(",");

        Assertions.assertThat(inputValidation.isValidCoachCanNotEatMenuCount(canNotEatMenus.length)).isTrue();
    }
}
