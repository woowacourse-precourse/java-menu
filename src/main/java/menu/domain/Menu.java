package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import menu.constant.MenuConstants;
import menu.util.Validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Menu {
    private final List<String> coachNames;
    private final List<Coach> coaches = new ArrayList<>();
    private final List<String> previousCategories = new ArrayList<>();

    public Menu(String coachNames) {
        List<String> splittedCoaches = List.of(coachNames.split(MenuConstants.DELIMITER));

        Validator.validateNumberOfCoaches(splittedCoaches.size());
        Validator.validateDuplication(splittedCoaches);
        splittedCoaches.stream()
                .map(String::length)
                .forEach(Validator::validateCoachNameLength);

        this.coachNames = splittedCoaches;
    }

    public void addCoach(String name, String inedibleMenu) {
        coaches.add(new Coach(name, inedibleMenu));
    }

    public void recommendForWeek() {
        for (int i = 0 ; i < MenuConstants.NUMBER_OF_DAYS; i++) {
            recommendForDay();
        }
    }

    private void recommendForDay() {
        Category category = pickCategory();
        coaches.forEach(coach -> pickMenu(coach, category));
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
        return coachNames;
    }
}
