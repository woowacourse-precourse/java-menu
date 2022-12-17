package menu.view;

import static menu.domain.CategoryRepository.weekCategories;
import static menu.domain.CoachRepository.coaches;
import static menu.util.message.OutputMessage.FINISH_RECOMMEND;
import static menu.util.message.OutputMessage.RECOMMEND_RESULT;
import static menu.util.message.OutputMessage.START_PROGRAM;
import static menu.util.message.ResultMessage.DELIMITER;
import static menu.util.message.ResultMessage.END_SYMBOL;
import static menu.util.message.ResultMessage.RESULT_CATEGORY;
import static menu.util.message.ResultMessage.RESULT_TITLE;
import static menu.util.message.ResultMessage.START_SYMBOL;

public class OutputView {

    public void printStartMessage() {
        System.out.println(START_PROGRAM);
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    public void printRecommendMenu() {
        System.out.println(RECOMMEND_RESULT);
        System.out.println(RESULT_TITLE);
        System.out.print(START_SYMBOL + RESULT_CATEGORY + DELIMITER);
        printCategory();
        System.out.println();
        for (int i = 0; i < coaches().size(); i++) {
            System.out.print(START_SYMBOL + coaches().get(i).getName() + DELIMITER);
            printRecommendMenuForEachCoach(i);
            System.out.println();
        }
    }

    private void printCategory() {
        for (int day = 1; day <= 5; day++) {
            System.out.print(weekCategories().get(day - 1).getName());
            if (day != 5) {
                System.out.print(DELIMITER);
                continue;
            }
            System.out.print(END_SYMBOL);
        }
    }

    private static void printRecommendMenuForEachCoach(int index) {
        for (int day = 1; day <= 5; day++) {
            System.out.print(coaches().get(index).getAlreadyEatMenu().get(day - 1));
            if (day != 5) {
                System.out.print(DELIMITER);
                continue;
            }
            System.out.print(END_SYMBOL);
        }
    }
    public void printFinishMessage() {
        System.out.println(FINISH_RECOMMEND);
    }
}
