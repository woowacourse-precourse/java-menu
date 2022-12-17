package menu.uitli;

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
}
