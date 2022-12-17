package menu.view;

import menu.model.Coach;
import menu.model.Table;

import java.util.List;

public class OutputView {
    private static final String[] days = {"월요일", "화요일", "수요일", "목요일", "금요일"};

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

    public static void showResult(int[] suggestedCategory, List<Coach> coaches) {
        System.out.println();
        System.out.println(Message.RESULT.getMessage());
        printMenu(suggestedCategory, coaches);
        System.out.println();
        System.out.println(Message.END.getMessage());
    }

    private static void printMenu(int[] suggestedCategory, List<Coach> coaches) {
        printDay();
        for (Coach coach : coaches) {
            printEachMenu(coach);
        }
    }

    private static void printDay() {
        StringBuilder sb = new StringBuilder();
        sb.append(Table.START.getSign())
                .append(Table.DAY.getSign());
        for (int i = 0; i < days.length; i++) {
            sb.append(Table.DELIMITER.getSign())
                    .append(days[i]);
        }
        sb.append(Table.END.getSign());
        System.out.println(sb);
    }

    private static void printEachMenu(Coach coach) {
        StringBuilder sb = new StringBuilder();
        sb.append(Table.START.getSign())
                .append(coach.getName());
        List<String> eatMenu = coach.getEatMenu();
        for (int i = 0; i < eatMenu.size(); i++) {
            sb.append(Table.DELIMITER.getSign())
                    .append(eatMenu.get(i));
        }
        sb.append(Table.END.getSign());
        System.out.println(sb);
    }
}
