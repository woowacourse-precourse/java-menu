package menu.view;

import java.util.List;
import menu.domain.Coach;
import menu.domain.CoachRepository;
import menu.utils.constants.IOComments;

public class OutputView {

    public void gameStartOutput() {
        System.out.println(IOComments.START_RECOMMEND.getComments());
        System.out.println(IOComments.INPUT_COACH_NAME.getComments());
    }

    public void emptyLine() {
        System.out.println();
    }

    public void unEatableFoodOutput(String coachName) {
        System.out.println(coachName + IOComments.INPUT_UNEATABLE_FOOD.getComments());
    }

    public void resultOutput(List<String> categories) {
        System.out.println(IOComments.RESULT_RECOMMEND.getComments());
        printCategories(categories);
        for (Coach coach : CoachRepository.coaches()) {
            resultNameOutput(coach);
            for (String menu : coach.getSelectedMenus()) {
                System.out.print(IOComments.RESULT_DELIMITER.getComments() + menu);
            }
            System.out.println(IOComments.RESULT_END_BRACKET.getComments());
        }
        System.out.println("추천을 완료했습니다.");
    }

    private static void printCategories(List<String> categories) {
        System.out.print(IOComments.RESULT_START_BRACKET.getComments());
        System.out.print("카테고리");
        for (int i = 0; i < 5; i++) {
            System.out.print(IOComments.RESULT_DELIMITER.getComments() + categories.get(i));
        }
        System.out.println(IOComments.RESULT_END_BRACKET.getComments());
    }

    private static void resultNameOutput(Coach coach) {
        System.out.print(IOComments.RESULT_START_BRACKET.getComments());
        System.out.print(coach.getName());
    }
}
