package menu.view;

import menu.domain.WeeklyMenus;

public class OutputView {
   private static final String ERROR_PREFIX = "[ERROR] ";

   public static void printStartMessage() {
       System.out.println("점심 메뉴 추천을 시작합니다.");
   }

   public static void printErrorMessage(String message) {
       System.out.println(ERROR_PREFIX + message);
   }

    public static void printWeeklyMenus(WeeklyMenus weeklyMenus) {
        System.out.println("메뉴 추천 결과입니다.");
        System.out.println(weeklyMenus.getDays());
        System.out.println(weeklyMenus.getCategories());
        weeklyMenus.getCoachesMenus().forEach(System.out::println);
        System.out.println("추천을 완료했습니다.");
    }
}