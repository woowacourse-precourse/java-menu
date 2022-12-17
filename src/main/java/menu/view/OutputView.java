package menu.view;

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

    public void resultOutput() {
        System.out.println(IOComments.RESULT_RECOMMEND.getComments());

        for (Coach coach : CoachRepository.coaches()) {
            resultNameOutput(coach);
            for (String menu : coach.getSelectedMenus()) {
                System.out.print(IOComments.RESULT_DELIMITER.getComments() + menu);
            }
            System.out.println(IOComments.RESULT_END_BRACKET.getComments());
        }
    }

    private static void resultNameOutput(Coach coach) {
        System.out.print(IOComments.RESULT_START_BRACKET.getComments());
        System.out.print(coach.getName());
    }
}
