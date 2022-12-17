package menu.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidation {

    public static final int MINIMUM_LIST_SIZE = 2;
    public static final int MAXIMUM_LIST_SIZE = 5;
    public static final int MINIMUM_NAME_LENGTH = 2;
    public static final int MAXIMUM_NAME_LENGTH = 4;
    public static final int MAXIMUM_HATE_FOODS_SIZE = 2;

    public static void validateNames(List<String> names) {
        validateListSize(names);
        validateNameSize(names);
        validateDuplicate(names);
    }

    public static void validateDuplicate(List<String> names) {
        Set<String> set = new HashSet<>(names);

        if (set.size() != names.size()) {
            throw new IllegalArgumentException("중복된 이름이 사용되었습니다.");
        }
    }

    public static void validateListSize(List<String> names) {
        if (names.size() < MINIMUM_LIST_SIZE || MAXIMUM_LIST_SIZE < names.size()) {
            throw new IllegalArgumentException("코치는 최소 2명, 최대 5명까지 식사를 함께 할 수 있습니다.");
        }
    }

    public static void validateNameSize(List<String> names) {
        for (String name : names) {
            if (name.length() < MINIMUM_NAME_LENGTH || MAXIMUM_NAME_LENGTH < name.length()) {
                throw new IllegalArgumentException("이름은 최소 2글자, 최대 4글자로 입력해주세요.");
            }
        }
    }

    public static void validateHateFoodsSize(List<String> hateFoods) {
        if (hateFoods.size() > MAXIMUM_HATE_FOODS_SIZE) {
            throw new IllegalArgumentException("편식은 두 개까지만 가능합니다.");
        }
    }
}
