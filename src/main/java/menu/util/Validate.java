package menu.util;

import java.util.List;

public class Validate {
    public static void nameLength(List<String> names, int minInclusive, int maxInclusive) {
        names.stream().forEach(name -> {
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

    private enum Message {
        ERROR_DIFFERENT_NAME_LENGTHS("[ERROR] 코치의 이름은 최소 2글자, 최대 4글자이다."),
        ERROR_DIFFERENT_COACH_LENGTHS("[ERROR] 코치는 최소 2명, 최대 5명까지 식사를 함께 한다."),
        ERROR_DIFFERENT_CANT_EAT_LENGTHS("[ERROR] 각 코치는 최소 0개, 최대 2개의 못 먹는 메뉴가 있다.");

        private final String message;

        Message(String message) {
            this.message = message;
        }
        }
}
