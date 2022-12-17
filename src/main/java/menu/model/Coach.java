package menu.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Coach {
    private static final String INVALID_NAME = "코치의 이름이 올바르지 않습니다.";
    public static final String ALREADY_REGISTERED = "해당 코치가 못 먹는 메뉴로 이미 등록돼있습니다.";
    public static final String INVALID_EXECUTION_FOR_RECOMMENDATION = "메뉴 추천은 5일만 할 수 있습니다.";
    private final String name;

    public List<String> getRecommendationForWeek() {
        return recommendationForWeek;
    }

    private final List<String> menuCannotToEat = new ArrayList<>();

    public static final String CANNOT_REGISTER_DUPLICATE_MENU_FOR_WEEK = "한 주에 중복된 메뉴를 선택할 수 없습니다.";

    private final List<String> recommendationForWeek = new ArrayList<>();

    public Coach(String name) {
        validateName(name);
        this.name = name;
    }

    public String getName() {
        return name;

    }

    public void validateName(String name) {
        if (name.length() < 2 || name.length() > 4) {
            throw new IllegalArgumentException(INVALID_NAME);
        }
    }

    public void addMenuCannotEat(String menu) {
        if (isAlreadyRegistered(menu)) {
            throw new IllegalArgumentException(ALREADY_REGISTERED);
        }
        menuCannotToEat.add(menu);
    }

    private boolean isAlreadyRegistered(String menu) {
        return menuCannotToEat.contains(menu);
    }

    public List<String> getMenuCannotToEat() {
        return new ArrayList<>(menuCannotToEat);
    }

    public int getSizeOfMenuCannotToEat(){
        return menuCannotToEat.size();
    }

    public void recommendMenu(Category category, Set<String> totalMenuCoachCannotToEat) {
        String recommendMenu = pickMenuSatisfiesAllConditions(category, totalMenuCoachCannotToEat);
        addMenu(recommendMenu);
    }

    private String pickMenuSatisfiesAllConditions(Category category, Set<String> totalMenuCoachCannotToEat) {
        String recommendMenu = null;
        while (true) {
            recommendMenu = category.getRandomMenu();
            if (!totalMenuCoachCannotToEat.contains(recommendMenu) && !recommendationForWeek.contains(recommendMenu)) {
                break;
            }
        }
        return recommendMenu;
    }

    private void addMenu(String menu) {
        if (recommendationForWeek.size() >= 5) {
            throw new IllegalStateException(INVALID_EXECUTION_FOR_RECOMMENDATION);
        }
        recommendationForWeek.add(menu);
    }

}
