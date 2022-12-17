package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import menu.constant.MenuConstants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Menu {
    private CoachList coachList;
    private final List<String> previousCategories = new ArrayList<>();

    public void addCoachNames(String coachNames) {
        coachList = new CoachList(coachNames);
    }

    public void addCoach(String name, String inedibleMenu) {
        coachList.add(name, inedibleMenu);
    }

    public void recommendForWeek() {
        for (int i = 0; i < MenuConstants.NUMBER_OF_DAYS; i++) {
            recommendForDay();
        }
    }

    private void recommendForDay() {
        Category category = pickCategory();
        coachList.getCoachList().forEach(coach -> pickMenu(coach, category));
    }

    private Category pickCategory() {
        int categoryIndex = Randoms.pickNumberInRange(MenuConstants.FIRST_CATEGORY, MenuConstants.LAST_CATEGORY);
        Category category = Arrays.stream(Category.values())
                .collect(Collectors.toList())
                .get(categoryIndex - 1);

        if (previousCategories.stream()
                .filter(previousCategory -> previousCategory.equals(category.getCategory()))
                .count() == MenuConstants.MAXIMUM_NUMBER_OF_CATEGORIES) {
            return pickCategory();
        }
        previousCategories.add(category.getCategory());
        return category;
    }

    private void pickMenu(Coach coach, Category category) {
        List<String> menus = category.getMenus();
        String menu = Randoms.shuffle(menus).get(0);

        if (coach.isEdible(menu)) {
            coach.eat(menu);
            return;
        }
        pickMenu(coach, category);
    }

    public List<String> getCoachNames() {
        return coachList.getCoachNames();
    }

    public List<Coach> getCoachList() {
        return coachList.getCoachList();
    }

    public List<String> getPreviousCategories() {
        return previousCategories;
    }
}
