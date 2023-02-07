package menu.util;

public class CoachValidator extends Validator{

    public static void isValidCoachName(String input) {
        isEmpty(input);
//        isDigit(input);
        if (!isValidRangeCoachName(input)) {
            throw new IllegalArgumentException("코치의 이름은 최소 2글자, 최대 4글자여야 합니다.");
        }
        if (!isRightCoachesCount(input)) {
            throw new IllegalArgumentException("코치는 최소 2명, 최대 5명까지 식사를 함께 해야 합니다.");
        }
    }

    private static boolean isValidRangeCoachName(String input) {
        String[] coaches = input.split(",");
        for (String name : coaches) {
            if (name.length() < 2 || name.length() > 4) {
                throw new IllegalArgumentException();
            }
        }
        return true;
    }

    public static boolean isRightCoachesCount(String input) {
        String[] coaches = input.split(",");
        return coaches.length >= 2 && coaches.length <= 5;
    }
}
