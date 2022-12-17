package menu.view;

import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Weekly;
import menu.domain.WeeklyRecommendCategory;

import java.util.List;

import static menu.constatnts.Constants.*;

public class OutputView {
    private static final String START_MSG = "[ ";
    private static final String OR_MSG = " | ";
    private static final String FINISH_MSG = " ]\n";

    public void printRecommendedMenu(List<Coach> allCoach, WeeklyRecommendCategory weeklyCategory) {
        System.out.println();
        System.out.println(PRINT_RECOMMEND_FOOD_MSG);
        printWeeklyDay();
        printWeeklyRecommendCategory(weeklyCategory);
        for (Coach coach : allCoach) {
            printMealsEachCoach(coach);
        }
        System.out.println();
        System.out.println(PRINT_RECOMMEND_FOOD_END_MSG);
    }

    private void printMealsEachCoach(Coach coach) {
        System.out.print(START_MSG);
        System.out.print(coach.getName());
        for (String meals : coach.getMeals()) {
            System.out.print(OR_MSG + meals);
        }
        System.out.print(FINISH_MSG);
    }

    private void printWeeklyDay() {
        System.out.print(START_MSG);
        System.out.print(PRINT_SUBJECT_DAY_MSG);
        for (String day : Weekly.getAllDays()) {
            System.out.print(OR_MSG + day);
        }
        System.out.print(FINISH_MSG);
    }

    private void printWeeklyRecommendCategory(WeeklyRecommendCategory weeklyCategory) {
        System.out.print(START_MSG);
        System.out.print(PRINT_CATEGORY_DAY_MSG);
        for (int idx : weeklyCategory.getCategoryIdxs()) {
            System.out.print(OR_MSG + Category.getWantCategoryName(idx));
        }
        System.out.print(FINISH_MSG);
    }
}
