package menu.view;

import menu.domain.CoachGroup;
import menu.utils.Category;
import menu.utils.OutputMessage;
import menu.utils.Weekend;

import java.util.List;

public class OutputView {

    public void printInitRecommend() {
        System.out.println(OutputMessage.INIT_PROGRAM.getMessage());
    }

    public void printReadCouchName() {
        System.out.println(OutputMessage.INPUT_COUCH_NAME.getMessage());
    }

    public void printReadDeniedFood(String name) {
        System.out.printf(OutputMessage.INPUT_COUCH_CANNOT_EAT.getMessage(), name);
    }

    public void printResult(CoachGroup coachGroup, List<Category> categories) {
        System.out.println(OutputMessage.RECOMMEND_RESULT.getMessage());
        printWeekend();
        printCategories(categories);
        printCouchGroup(coachGroup);
        printComplete();
    }

    private void printComplete() {
        System.out.println(OutputMessage.RECOMMEND_COMPLETE.getMessage());
    }

    private void printCouchGroup(CoachGroup coachGroup) {
        System.out.println(coachGroup.toMessage());
    }

    private void printCategories(List<Category> categories) {
        System.out.println(Category.toMessage(categories));
    }

    private void printWeekend() {
        System.out.println(Weekend.toMessage());
    }
}
