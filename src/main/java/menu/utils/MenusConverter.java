package menu.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import menu.domain.Category;
import menu.repository.MenuRepository;

public class MenusConverter {

    private MenusConverter() {
    }

    public static List<String> convert(String input) {
        List<String> menus = getMenus(input);
        validate(menus);
        return menus;
    }

    private static List<String> getMenus(String input) {
        return Arrays.stream(input.split(","))
                .map(s -> s.trim())
                .filter(s -> s.length() != 0)
                .collect(Collectors.toList());
    }

    private static void validate(List<String> menus) {
        for (Category category : Category.values()) {
            List<String> existMenus = MenuRepository.findByCategory(category);
            validateExistMenu(menus, existMenus);
        }
        validateSize(menus);
    }

    private static void validateExistMenu(List<String> menus, List<String> existMenus) {
        for (String menu : menus) {
            if (!existMenus.contains(menu)) {
                throw new IllegalArgumentException("존재하지 않는 메뉴입니다.");
            }
        }
    }

    private static void validateSize(List<String> menus) {
        if (menus.size() < 0 || menus.size() > 2) {
            throw new IllegalArgumentException("각 코치는 최소 0개, 최대 2개의 못 먹는 메뉴가 있다.");
        }
    }
}
