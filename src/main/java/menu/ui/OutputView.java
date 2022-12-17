package menu.ui;

import java.util.List;
import java.util.Stack;
import menu.Coach;

public class OutputView {

    private static final String GAME_START = "점심 메뉴 추천을 시작합니다.";
    private static final String GAME_RESULT_MESSAGE = "메뉴 추천 결과입니다.";
    private static final String DAYS = "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]";
    private static final String RECOMMAND_FINISH = "추천을 완료했습니다.";

    public static void printMenuGameStart() {
        System.out.println(GAME_START);
    }

    public static void printCoachNumberIsNotValid() {
        System.out.println();
    }

    public static void printErrorMessage(String message) {
        System.out.println(message);
    }

    public static void printMenuGameResult(Stack<String> menuCategoryForEachDay, List<Coach> coaches) {
        System.out.println(GAME_RESULT_MESSAGE);
        System.out.println(DAYS);
        printMenuCategoryForEachDay(menuCategoryForEachDay);
        printCoachesMenuName(coaches);
        System.out.println(RECOMMAND_FINISH);
    }

    private static void printCoachesMenuName(List<Coach> coaches) {
        for(Coach coach : coaches){
            System.out.print("[ " + coach.getName() + " | ");
            for(int i = 0; i < coach.getMenuNameForEachDay().size() - 1; i++){
                System.out.print(coach.getMenuNameForEachDay().get(i) + " | ");
            }
            System.out.println(coach.getMenuNameForEachDay().get(coach.getMenuNameForEachDay().size() - 1) + " ]");
        }
    }

    private static void printMenuCategoryForEachDay(Stack<String> menuCategoryForEachDay) {
        System.out.print("[ 카테고리 | ");
        for(int i = 0; i < menuCategoryForEachDay.size() - 1; i++){
            System.out.print(menuCategoryForEachDay.get(i) + " | ");
        }
        System.out.println(menuCategoryForEachDay.get(menuCategoryForEachDay.size() - 1) + " ]");
    }
}
