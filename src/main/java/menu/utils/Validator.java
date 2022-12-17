package menu.utils;

public class Validator {

    public static void checkCoachesCount(String[] inputCoachNames) {
        if (!(2 <= inputCoachNames.length && inputCoachNames.length <= 5)) {
            throw new IllegalArgumentException("코치는 2명에서 5명까지 입력이 가능합니다.");
        }
    }
}
