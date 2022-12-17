package menu.view;

import menu.domain.CategoryEnum;

import java.util.List;

public class OutputView {
    public OutputView() {};

    public static void printStartMsg() {
        System.out.println("점심 메뉴 추천을 시작합니다.\n");
    }

    public static void printInputCoaches() {
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
    }

    public static void printError(String msg) {
        System.out.println("[ERROR] " + msg);
    }

    public static void printInputInEdible(String coach) {
        System.out.println("\n" + coach + "(이)가 못 먹는 메뉴를 입력해 주세요.");
    }

    public static void printResult(List<String> coachesName, List<String[]> menu, List<Integer> category) {
        System.out.println("\n메뉴 추천 결과입니다.");
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
        printCategory(category);
        printCoachMenu(coachesName, menu);
        System.out.println("\n추천을 완료했습니다.");
    }

    public static void printCategory(List<Integer> category) {
        System.out.print("[ 카테고리");
        for (int i = 0; i < category.size(); i++)
            System.out.print(" | "+CategoryEnum.getMessageByValue(category.get(i)));
        System.out.println(" ]");
    }

    public static void printCoachMenu(List<String> coachesName, List<String[]> menu) {
        for (int i = 0; i < coachesName.size(); i++) {
            System.out.print("[ "+coachesName.get(i));
            printMenu(menu.get(i));
        }
    }

    public static void printMenu(String[] menu) {
        for (int i = 0 ; i < menu.length; i++)
            System.out.print(" | " +menu[i]);
        System.out.println(" ]");
    }
}
