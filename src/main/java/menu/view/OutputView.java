package menu.view;

import menu.Coach;
import menu.Day;
import menu.DaysName;
import menu.Menu;
import menu.Service;

public class OutputView {

    private static final String DIVIDE = " | ";
    private static final String START = "[ ";
    private static final String END = " ]";
    private static final String DAY = "구분";
    private static final String CATEGORY = "카테고리";

    public static void print(PrintMessages printMessage) {
        System.out.println(printMessage.getMessage());
    }

    public static void start() {
        print(PrintMessages.SERVICE_START);
    }

    public static void insertCoaches() {
        print(PrintMessages.INSERT_COACHES);
    }

    public static void insertHateMenuBy(Coach coach) {
        System.out.println(PrintMessages.hateMenuBy(coach));
    }

    public static void showDays() {
        print(PrintMessages.RESULT);
        String result = START + DAY;
        for (DaysName day : DaysName.values()) {
            result += DIVIDE + day.getKorean();
        }
        result += END;
        System.out.println(result);
    }

    public static void showCategories(Service service) {
        String result = START + CATEGORY;
        for (Day day : service.getDaysResult()) {
            result += DIVIDE + day.getCategory().getName();
        }
        result += END;
        System.out.println(result);
    }

    public static void showRecommended(Service service) {
        for (Coach coach : service.getGroup()) {
            String result = START + coach.getName();
            for (Menu menu : coach.getRecommended()) {
                result += DIVIDE + menu.getName();
            }
            result += END;
            System.out.println(result);
        }
        print(PrintMessages.FINISH);
    }
}
