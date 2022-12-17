package menu.view;

import menu.domain.Categories;
import menu.domain.Coach;
import menu.domain.Coaches;
import menu.constant.GuidanceMessage;
import menu.constant.ErrorMessage;

public class OutputView {

    public void printStart() {
        System.out.println(GuidanceMessage.SERVICE_INTRO);
    }

    public void requestCoachesName() {
        System.out.println();
        System.out.println(GuidanceMessage.INPUT_COACH_NAME);
    }

    public void requestInedibleFoods(String coachName) {
        System.out.println("\n" + coachName + GuidanceMessage.INPUT_INEDIBLE);
    }

    public void printResult(Categories categories, Coaches coaches) {
        System.out.println("\n" + GuidanceMessage.SERVICE_RESULT);
        System.out.println(GuidanceMessage.DAYS_OF_WEEK);
        printCategories(categories);
        printCoachFood(coaches);
        System.out.println("\n" + GuidanceMessage.SERVICE_OUTRO);
    }

    public void printCategories(Categories categories) {
        String printCategoryMap = "[ 카테고리 " + categories.toString() + "]";
        System.out.println(printCategoryMap);
    }

    public void printCoachFood(Coaches coaches) {
        for (Coach coach : coaches.getCoaches()) {
            System.out.println("[ " + coach.getName() + " " + coach.toString() + "]");
        }
    }

    public static void printError(String message) {
        System.out.println(ErrorMessage.PREFIX + message);
    }
}
