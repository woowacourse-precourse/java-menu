package menu.model.validate;

import menu.error.CoachErrorCode;
import menu.view.OutputView;

import java.util.List;
import java.util.regex.Pattern;

import static menu.error.CoachErrorCode.*;

/**
 * @author 최원용
 * @version 2.0.0
 * @Created by 최원용 on 2022. 12. 17.
 */

public class InputVerifier {

    public static void coachNameIsMin2Max4(String coachName) {
        if (coachName.length() < 2 || 4 < coachName.length()) {
            throw new IllegalArgumentException(COACH_NAME_IS_MIN_2_MAX_4.getMessage());
        }
    }

    public static void coachesCountMin2Max5(int size) {
        if (size < 2 || 5 < size) {
            throw new IllegalArgumentException(COACH_COUNT_MIN_2_MAX_5.getMessage());
        }
    }

    public static void tryCoachesHateMenu(List<String> hateMenus) {
        try {
            for (String hateMenu : hateMenus) {
                coachHateMenuIsKorean(hateMenu);
                coachHateMenusCount0To2(hateMenus.size());
            }
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
        }
    }

    private static void coachHateMenuIsKorean(String hateMenu) {
        if (!Pattern.matches("^[가-힣]*$", hateMenu)) {
            throw new IllegalArgumentException(HATE_MENU_INPUT_ONLY_KOREAN.getMessage());
        }
    }

    private static void coachHateMenusCount0To2(int hateMenuSize) {
        if (2 < hateMenuSize) {
            throw new IllegalArgumentException(HATE_MENU_SIZE_0_TO_2.getMessage());
        }
    }
}
