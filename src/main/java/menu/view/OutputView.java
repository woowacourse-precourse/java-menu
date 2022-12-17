package menu.view;

import java.util.List;
import menu.domain.Category;
import menu.domain.Result;

public class OutputView {
    public static void messageProgramStart() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
    }

    public static void messageNamesInput() {
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
    }

    public static void messageBanInput(String coachName) {
        System.out.println(coachName + "(이)가 못 먹는 메뉴를 입력해 주세요.");
    }

    public static void printResultMessage() {
        System.out.println("메뉴 추천 결과입니다.");
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
    }

    public static void printCategoryResult(Result result) {
        List<String> categoryResult = result.getSelectedCategory();
        System.out.println("[ 카테고리 | " + String.join(" | ", categoryResult) + " ]");
    }
}
