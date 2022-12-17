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

    private String[] validateUnavailableMenus(String input) {
        String[] split = input.split(DELIMITER);
        for (String s : split) {
            if (!s.matches(REGEX)) {
                throw new IllegalArgumentException("올바른 입력이 아닙니다. 쉽표로 구분하여 입력해주세요");
            }
        }
        if (split.length > UNAVAILABLE_MENU_COUNT_LIMIT) {
            throw new IllegalArgumentException("최대 2개의 못 먹는 메뉴만 입력할 수 있습니다.");
        }
        return split;
    }

    public String getName() {
        return name.getName();
    }

    public Menus getRecommended() {
        return recommended;
    }


    public void recommendMenu(String inputCategory, MenuRandomGenerator menuRandomGenerator) {
        Category category = Category.map(inputCategory);
        List<String> menus = Arrays.stream(Menu.values())
                .filter(m -> m.toString().startsWith(category.toString()))
                .map(Menu::getMenuName)
                .collect(Collectors.toList());

        while (true) {
            String generate = menuRandomGenerator.generate(menus);
            if (recommended.contains(generate) || unavailable.contains(generate)) {
                continue;
            }
            recommended.addMenu(Menu.map(generate));
            break;
        }
    }
}
