package menu.util;

import java.util.List;

/**
 * @Author : jeeseob
 * @CreateAt : 2022/12/17
 */
public class Validate {
    public static void validateCoachNames(List<String> coachName) {
        if (coachName.size() < 2) {
            throw new IllegalArgumentException(IllegalArgumentExceptionMessage.INPUT_COACH_LENGTH.getMessage());
        }
    }

    public static void validateHateMenu(List<String> hateMenus) {
        // TODO: 이후에 메뉴관련 정보를 처리하는 객체와 함수를 만들면, 구현
    }
}
