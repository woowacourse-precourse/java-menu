package menu.ui.dto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MenuRequest {
    private final List<String> menus;

    private MenuRequest(List<String> menus) {
        this.menus = menus;
    }

    public static MenuRequest from(String userInput) {
        validate(userInput);
        List<String> menus = Arrays.stream(userInput.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
        return new MenuRequest(menus);
    }

    private static void validate(String userInput) {
        String[] coaches = userInput.split(",");
        validateSize(coaches);
        validateDuplication(coaches);
    }

    private static void validateSize(String[] coaches) {
        if (coaches.length > 2) {
            throw new IllegalArgumentException("[ERROR] 못먹는 메뉴는 최대 2개만 입력 가능 합니다.");
        }
    }

    private static void validateDuplication(String[] coaches) {
        long distinctSize = Arrays.stream(coaches)
                .map(String::trim)
                .distinct()
                .count();

        if (distinctSize != coaches.length) {
            throw new IllegalArgumentException("[ERROR] 동일한 메뉴를 입력 할 수 없습니다.");
        }
    }

    public List<String> getMenus() {
        return menus;
    }
}
