package menu.util;

import menu.domain.Categories;

import java.util.ArrayList;
import java.util.List;

import static menu.util.TransformInput.splitInput;

public class InputValidator {
    private final static int MIN_SIZE = 2;
    private final static int MAX_SIZE = 5;
    private final static int MAX_MENU_SIZE = 2;
    private final static String INVALID_SIZE_ERROR = "[ERROR] 코치 이름은 최소 2명과 5명입니다.";
    private final static String INVALID_MENU_SIZE_ERROR = "[ERROR] 못먹는 메뉴는 최대 2개입니다.";
    private final static String INVALID_MENU_ERROR = "[ERROR] 존재하지 않는 메뉴입니다.";
    private final static int NAME_MIN_LENGTH = 2;
    private final static int NAME_MAX_LENGTH = 4;
    private final static String INVALID_LENGTH_ERROR_MESSAGE = "[ERROR] 코치 이름은 최소 2글자, 최대 4글자로 입력하세요.";

    public static void validateNameLength(String input) {
        List<String> names = splitInput(input);

        for (String name : names) {
            if (name.length() < NAME_MIN_LENGTH || name.length() > NAME_MAX_LENGTH) {
                throw new IllegalArgumentException(INVALID_LENGTH_ERROR_MESSAGE);
            }
        }
    }

    public static void validateNamesSize(String input) {
        List<String> names = splitInput(input);

        if (names.size() < MIN_SIZE || names.size() > MAX_SIZE){
            throw new IllegalArgumentException(INVALID_SIZE_ERROR);
        }
    }

    public static void validateMenuSize(String input) {
        List<String> menu = splitInput(input);

        if (menu.size() > MAX_MENU_SIZE){
            throw new IllegalArgumentException(INVALID_MENU_SIZE_ERROR);
        }
    }

    public static void validateInvalidMenu(String input) {
        List<String> menu = splitInput(input);

        List<String> allMenu = new ArrayList<>();
        for (Categories categories : Categories.values()) {
            for (String name : categories.getMenuNames()) {
                allMenu.add(name);
            }
        }
        System.out.println(allMenu.toString());
        System.out.println(menu);
        for (String check : menu) {
            if (!allMenu.contains(check)){
                throw new IllegalArgumentException(INVALID_MENU_ERROR);
            }
        }
    }
}
