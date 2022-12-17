package menu.domain;

import menu.domain.menu.Category;
import menu.domain.menu.Menu;
import menu.domain.menu.Menus;
import menu.util.MenuRandomGenerator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Person {

    public static final String DELIMITER = ",";
    public static final String REGEX = ".*[ㄱ-ㅎㅏ-ㅣ가-힣]+.*";
    public static final int UNAVAILABLE_MENU_COUNT_LIMIT = 2;

    private final Name name;
    private final Menus recommended = new Menus();
    private Menus unavailable;

    public Person(String name) {
        this.name = new Name(name);
    }

    public void addUnavailableMenus(String menus) {
        String[] split = validateUnavailableMenus(menus);
        List<Menu> result = Arrays.stream(split)
                .map(Menu::map)
                .collect(Collectors.toList());
        unavailable = new Menus(result);
    }

    private String[] validateUnavailableMenus(String menus) {
        String[] split = menus.split(DELIMITER);
        for (String menu : split) {
            if (!menu.matches(REGEX)) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_FORMAT);
            }
        }
        if (split.length > UNAVAILABLE_MENU_COUNT_LIMIT) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_UNAVAILABLE_COUNT);
        }
        return split;
    }


    public void recommendMenu(String inputCategory, MenuRandomGenerator menuRandomGenerator) {
        List<String> menus = getMenusByCategory(inputCategory);
        while (true) {
            String generate = menuRandomGenerator.generate(menus);
            if (recommended.contains(generate) || unavailable.contains(generate)) {
                continue;
            }
            recommended.addMenu(Menu.map(generate));
            break;
        }
    }

    private List<String> getMenusByCategory(String inputCategory) {
        Category category = Category.map(inputCategory);
        return Arrays.stream(Menu.values())
                .filter(m -> m.toString().startsWith(category.toString()))
                .map(Menu::getMenuName)
                .collect(Collectors.toList());
    }

    public String getName() {
        return name.getName();
    }

    public Menus getRecommended() {
        return recommended;
    }

    private static final class ErrorMessage {
        private static final String INVALID_INPUT_FORMAT = "올바른 입력이 아닙니다. 쉽표로 구분하여 입력해주세요";
        private static final String INVALID_UNAVAILABLE_COUNT = String.format("최대 %d개의 못 먹는 메뉴만 입력할 수 있습니다.", UNAVAILABLE_MENU_COUNT_LIMIT);
    }
}
