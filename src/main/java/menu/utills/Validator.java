package menu.utills;

import menu.utills.constants.CoachNameRule;
import menu.utills.constants.CoachQuantity;
import menu.utills.constants.ErrorMessage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
    public static <T> void isInSize(List<T> inputs, int min, int max) {
        if (min > inputs.size() || inputs.size() > max) {
            throw new IllegalArgumentException(String.format(ErrorMessage.OUT_OF_RANGE.getMessage(), min, max));
        }
    }

    public static <T> void containDuplicate(List<T> inputs) {
        Set<T> inputSet = new HashSet<>(inputs);
        if (inputSet.size() != inputs.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED.getMessage());
        }
    }

    public static void checkLength(List<String> inputs) {
        for (String input : inputs) {
            if (CoachNameRule.MIN. > input
                    || input > END_NUMBER) {
                throw new IllegalArgumentException(String.format(ErrorMessage.OUT_OF_RANGE.getMessage(), START_NUMBER, END_NUMBER));
            }
        }
    }
}
