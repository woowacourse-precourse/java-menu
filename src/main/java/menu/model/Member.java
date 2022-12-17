package menu.model;

import menu.view.ErrorMessage;

import java.util.*;

public class Member {
    private static final Integer MAX_CATEGORY = 2;

    private String name;
    private Set<Menu> cantEat = new HashSet<>();

    private List<Menu> eatHistory = new ArrayList<>();

    private Map<MenuCategory, Integer> categoryCount = new EnumMap<>(MenuCategory.class);

    public Member(String name) {
        validateMemberName(name);
        this.name = name;
        initCategoryCount();
    }

    private void initCategoryCount() {
        Arrays.stream(MenuCategory.values())
                .forEach(mc -> categoryCount.put(mc, 0));
    }

    public void setCantEat(List<Menu> menus) {
        cantEat.addAll(menus);
    }

    public boolean isCanEat(Menu menu) {
        boolean canEat = true;
        try {
            validateCantEat(menu);
            validateMenu(menu);
            validateCategory(menu.getMenuCategory());
        }catch (IllegalArgumentException e) {
            canEat = false;
        }
        return canEat;
    }

    public List<Menu> getEatHistory() {
        return eatHistory;
    }

    public void eat(Menu menu) {
        validateCantEat(menu);
        validateMenu(menu);
        validateCategory(menu.getMenuCategory());
        eatHistory.add(menu);
        addCategoryCount(menu.getMenuCategory());
    }

    public String getName() {
        return name;
    }

    private void addCategoryCount(MenuCategory menuCategory) {
        categoryCount.put(menuCategory, categoryCount.get(menuCategory) + 1);
    }

    private void validateCantEat(Menu menu) {
        if(cantEat.contains(menu)) {
            throw new IllegalArgumentException(ErrorMessage.CANT_EAT.getMessage());
        }
    }

    private void validateMemberName(String name) {
        if(name.length() < 2 || name.length() > 4) {
            throw new IllegalArgumentException(ErrorMessage.OUT_OF_RANGE_MEMBER_NAME.getMessage());
        }
    }

    private void validateCategory(MenuCategory menuCategory) {
        if(categoryCount.get(menuCategory) >= MAX_CATEGORY) {
            throw new IllegalArgumentException(ErrorMessage.OVER_CATEGORY.getMessage());
        }
    }

    private void validateMenu(Menu menu) {
        if(cantEat.contains(menu)) {
            throw new IllegalArgumentException(ErrorMessage.ALREADY_EAT.getMessage());
        }
    }
}
