package menu.view;

import menu.domain.*;

import java.text.MessageFormat;
import java.util.List;

import static menu.global.GlobalMessage.*;

public class OutputView {
    public void printRecommendMenuResult(MenuRecommendResult recommendResult) {
        List<Day> days = recommendResult.getDays();
        List<Category> categories = recommendResult.getCategories();
        List<Coach> coaches = recommendResult.getCoaches();

        System.out.print(ANNOUNCE_LUNCH_MENU_RECOMMEND_RESULT.getMessage());
        System.out.println(parseDayMessage(days));
        System.out.println(parseCategoryMessage(categories));
        coaches.forEach(coach -> System.out.println(parseCoachMenuMessage(coach)));
        System.out.print(ANNOUNCE_LUNCH_MENU_RECOMMEND_EXIT.getMessage());
    }

    private String parseDayMessage(List<Day> days) {
        return MessageFormat.format(
                ANNOUNCE_DAY.getMessage(),
                days.get(0).getDay(),
                days.get(1).getDay(),
                days.get(2).getDay(),
                days.get(3).getDay(),
                days.get(4).getDay()
        );
    }

    private String parseCategoryMessage(List<Category> categories) {
        return MessageFormat.format(
                ANNOUNCE_CATEGORY.getMessage(),
                categories.get(0).getName(),
                categories.get(1).getName(),
                categories.get(2).getName(),
                categories.get(3).getName(),
                categories.get(4).getName()
        );
    }

    private String parseCoachMenuMessage(Coach coach) {
        List<Food> foods = coach.loadRecommendFoods();
        return MessageFormat.format(
                ANNOUNCE_COACH.getMessage(),
                coach.loadName(),
                foods.get(0).loadName(),
                foods.get(1).loadName(),
                foods.get(2).loadName(),
                foods.get(3).loadName(),
                foods.get(4).loadName()
        );
    }
}
