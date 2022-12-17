package menu.view;

import menu.Coach;
import menu.Day;
import menu.DaysName;
import menu.Menu;
import menu.Service;

public class OutputView {

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
        System.out.println("메뉴 추천 결과입니다.");
        String result = "[ 구분";
        for (DaysName day : DaysName.values()) {
            result += " | " + day.getKorean();
        }
        result += " ]";
        System.out.println(result);
    }

    public static void showCategories(Service service) {
        String result = "[ 카테고리";
        for (Day day : service.getDaysResult()) {
            result += " | " + day.getCategory().getName();
        }
        result += " ]";
        System.out.println(result);
    }

    public static void showRecommended(Service service) {
        for (Coach coach : service.getGroup()) {
            String result = "[ " + coach.getName();
            for (Menu menu : coach.getRecommended()) {
                result += " | " + menu.getName();
            }
            result += " ]";
            System.out.println(result);
        }
        System.out.println("\n추천을 완료했습니다.");
    }
}
