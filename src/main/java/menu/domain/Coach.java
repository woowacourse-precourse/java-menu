package menu.domain;

import menu.domain.enums.Category;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;

public class Coach {

    private static final int MIN_NAME_SIZE = 2;
    private static final int MAX_NAME_SIZE = 4;
    private static final int MAX_DUPLICATED_COUNT = 2;
    private static final String ERROR_NAME_SIZE_FORMAT = "코치의 이름은 최소 %d글자, 최대 %d글자 입니다.";

    private final String name;
    private final List<Menu> inedibleMenus;
    private final List<Menu> recommendedMenus = new ArrayList<>();

    public Coach(final String name, final List<Menu> inedibleMenus) {
        validateName(name);
        this.name = name;
        this.inedibleMenus = inedibleMenus;
    }

    private void validateName(String name) {
        if (name.length() < MIN_NAME_SIZE || name.length() > MAX_NAME_SIZE) {
            throw new IllegalArgumentException(
                    format(ERROR_NAME_SIZE_FORMAT, MIN_NAME_SIZE, MAX_NAME_SIZE)
            );
        }
    }

    public static Coach ofName(final String name) {
        return new Coach(name, new ArrayList<>());
    }

    public String name() {
        return name;
    }

    public List<Menu> recommendedMenus() {
        return recommendedMenus;
    }

    public boolean isDuplicatedCategory(final Category category) {
        long count = inedibleMenus.stream()
                .filter(it -> it.category().equals(category))
                .count();
        return MAX_DUPLICATED_COUNT <= count;
    }

    public boolean isEdible(final Menu menu) {
        return !inedibleMenus.contains(menu);
    }

    public void addInedibleMenus(final List<Menu> menus) {
        inedibleMenus.addAll(menus);
    }

    public void addRecommendedMenus(final Menu menu) {
        this.recommendedMenus.add(menu);
    }
}
