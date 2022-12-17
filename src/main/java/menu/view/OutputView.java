package menu.view;

public class OutputView {
    public static void start() {
        System.out.println(Message.START.getMessage());
        System.out.println();
    }

    public static void askCoach() {
        System.out.println(Message.ASK_COACH.getMessage());
    }

    public static void askNoEat(String name) {
        System.out.println();
        System.out.println(name + Message.ASK_NO_EAT.getMessage());
    }
}
