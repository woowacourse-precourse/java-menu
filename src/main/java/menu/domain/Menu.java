package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import menu.constant.ExceptionConstants;
import menu.constant.MenuConstants;
import menu.util.Validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Menu {
    private final List<String> coachNames = new ArrayList<>();
    private final List<Coach> coaches = new ArrayList<>();
    private final List<String> previousCategories = new ArrayList<>();

    public void addCoachNames(String coachNames) {
        List<String> splittedCoachNames = List.of(coachNames.split(MenuConstants.INPUT_DELIMITER));
        validateCoachNames(splittedCoachNames);
        this.coachNames.addAll(splittedCoachNames);
    }

    private void validateCoachNames(List<String> splittedCoachNames) {
        Validator.validateLowerBound(splittedCoachNames.size(),
                MenuConstants.MINIMUM_NUMBER_OF_COACHES,
                ExceptionConstants.NOT_ENOUGH_COACH);

        Validator.validateUpperBound(splittedCoachNames.size(),
                MenuConstants.MAXIMUM_NUMBER_OF_COACHES,
                ExceptionConstants.TOO_MANY_COACHES);

        Validator.validateDuplication(splittedCoachNames);
        splittedCoachNames.stream()
                .map(String::length)
                .forEach(this::validateCoachNameLength);
    }

    private void validateCoachNameLength(int coachNameLength) {
        Validator.validateLowerBound(coachNameLength,
                MenuConstants.MINIMUM_COACH_NAME_LENGTH,
                ExceptionConstants.TOO_SHORT_NAME_LENGTH);

        Validator.validateUpperBound(coachNameLength,
                MenuConstants.MAXIMUM_COACH_NAME_LENGTH,
                ExceptionConstants.TOO_LONG_NAME_LENGTH);
    }

    public void addCoach(String name, String inedibleMenu) {
        coaches.add(new Coach(name, inedibleMenu));
    }

    public void recommendForWeek() {
        for (int i = 0; i < MenuConstants.NUMBER_OF_DAYS; i++) {
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

    public List<Coach> getCoaches() {
        return coaches;
    }

    public List<String> getPreviousCategories() {
        return previousCategories;
    }
}
