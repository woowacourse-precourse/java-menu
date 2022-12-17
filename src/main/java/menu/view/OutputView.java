package menu.view;

public class OutputView {
    public static void start() {
        System.out.println(Message.START.getMessage());
        System.out.println();
    }

    public static void askCoach() {
        System.out.println(Message.INPUT_COACH.getMessage());
    }
}
