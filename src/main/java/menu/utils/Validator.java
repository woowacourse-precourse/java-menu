package menu.utils;

public class Validator {
    public static void checkNameLength(String name) {
        int nameLength = name.length();
        if (nameLength < 2 || nameLength > 4) {
            throw new IllegalArgumentException("[ERROR] 코치 이름은 최소 2글자에서 최대 4글자여야 합니다.");
        }
    }
}
