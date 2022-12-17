package menu.utils;

public class Validation {

    private static final int COACH_MIN_SIZE = 2;
    private static final int COACH_MAX_SIZE = 5;

    public static void isCoachNames(String target) {
        isInCoachSize(target);
    }

    private static void isInCoachSize(String target) {
        String[] coachs = target.split(",");
        isNotSmallerThanMinSize(coachs, COACH_MIN_SIZE);
        isNotBiggerThanMaxSize(coachs, COACH_MAX_SIZE);
    }

    private static void isNotSmallerThanMinSize(String[] targets, int minSize) {
        if(targets.length < minSize) {
            throw new IllegalArgumentException(ExceptionType.IS_LOWER_THAN_SIZE.toString());
        }
    }

    private static void isNotBiggerThanMaxSize(String[] targets, int maxSize) {
        if(targets.length > maxSize) {
            throw new IllegalArgumentException(ExceptionType.IS_BIGGER_THAN_SIZE.toString());
        }
    }
}
