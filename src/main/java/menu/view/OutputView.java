package menu.view;

import menu.domain.Coach;

public class OutputView {

    public void printServiceStart() {
        System.out.println(Message.SERVICE_START.getMessage());
    }

    public void printInputCoach() {
        System.out.println(Message.INPUT_COACH.getMessage());
    }

    public void printImpossibleToEat(Coach coach) {
        System.out.println(String.format(Message.IMPOSSIBLE_TO_EAT.getMessage(), coach.getName()));
    }

    public static void printErrorMessage(String message) {
        System.out.println(String.format(Message.ERROR.getMessage(), message));
    }
}
