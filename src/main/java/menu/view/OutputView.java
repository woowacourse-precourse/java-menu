package menu.view;

public class OutputView {
   private static final String ERROR_PREFIX = "[ERROR] ";

   public static void printStartMessage() {
       System.out.println("점심 메뉴 추천을 시작합니다.");
   }

   public static void printErrorMessage(String message) {
       System.out.println(ERROR_PREFIX + message);
   }
}