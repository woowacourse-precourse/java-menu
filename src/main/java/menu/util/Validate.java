package menu.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validate {
    public static void isName(String name) {
        if (!name.matches("[가-힣]*$")) {
            if (!name.matches("[a-zA-Z ]*$")) {
                throw new IllegalArgumentException(Message.ERROR_NOT_NAME.message);
            }
        }
    }

    public static void nameLength(List<String> names, int minInclusive, int maxInclusive) {
        names.stream().forEach(name -> {
                    isName(name);
                    if (name.length() < minInclusive || name.length() > maxInclusive) {
                        throw new IllegalArgumentException(Message.ERROR_DIFFERENT_NAME_LENGTHS.message);
                    }
                }
        );
    }

    public static void coachLength(List<String> names, int minInclusive, int maxInclusive) {
        if (names.size() < minInclusive || names.size() > maxInclusive) {
            throw new IllegalArgumentException(Message.ERROR_DIFFERENT_COACH_LENGTHS.message);
        }
    }

    public static void cantEatLength(List<String> names, int minInclusive, int maxInclusive) {
        if (names.size() < minInclusive || names.size() > maxInclusive) {
            throw new IllegalArgumentException(Message.ERROR_DIFFERENT_CANT_EAT_LENGTHS.message);
        }
    }

    public static void duplication(List<String> names) {
        Set<String> sameNumber = new HashSet<>(names);
        if (names.size() != sameNumber.size()) {
            throw new IllegalArgumentException(Message.ERROR_DUPLICATE_VALUE.message);
        }
    }

    private enum Message {
        ERROR_DIFFERENT_NAME_LENGTHS("[ERROR] 코치의 이름은 최소 2글자, 최대 4글자이다."),
        ERROR_DIFFERENT_COACH_LENGTHS("[ERROR] 코치는 최소 2명, 최대 5명까지 식사를 함께 한다."),
        ERROR_DIFFERENT_CANT_EAT_LENGTHS("[ERROR] 각 코치는 최소 0개, 최대 2개의 못 먹는 메뉴가 있다."),
        ERROR_DUPLICATE_VALUE("[ERROR] 중복 값이 포함되어 있습니다."),
        ERROR_NOT_NAME("[ERROR] 이름이 아닙니다.");

        private final String message;

        Message(String message) {
            this.message = message;
        }
    }
}
