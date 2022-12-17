package menu.view;

import menu.domain.Category;
import menu.domain.Member;

import java.util.List;

public class OutputView {
    private static final String ERROR = "[ERROR]";

    public static void printStart() {
        System.out.println("점심 메뉴 추천을 시작합니다.\n");
    }

    public static void printResult(List<Category> categoryList, List<Member> members) {
        System.out.println("메뉴 추천 결과입니다.");
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
        for (Member member : members) {
            System.out.print("[ " + member.getName());
            for (String menu : member.getWeekEat()) {
                System.out.print(" | " + menu);
            }
            System.out.println(" ]\n");
        }
        System.out.println("추천을 완료했습니다.");
    }
}
