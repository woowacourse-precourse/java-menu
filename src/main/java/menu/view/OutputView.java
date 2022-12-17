package menu.view;

import menu.model.Table;

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

    public static void showResult(int[] suggestedCategory) {
        System.out.println();
        System.out.println(Message.RESULT.getMessage());
        printMenu(suggestedCategory);
    }

    private static void printMenu(int[] suggestedCategory) {
        printDay();

    }

    private static void printDay() {
        StringBuilder sb = new StringBuilder();
        sb.append(Table.START.getSign())
                .append(Table.DAY.getSign());
        for (int i = 0; i < days.length; i++) {
            sb.append(Table.DELIMITER.getSign())
                    .append(days[i]);
        }
        sb.append(Table.END.getSign())
                .append("\n");
        System.out.println(sb);
    }
}
