package menu.view;

import java.util.ArrayList;
import java.util.List;
import menu.domain.Category;
import menu.domain.CategoryResult;
import menu.domain.Coach;

public class Output {
    private static final String NEW_LINE = "\n";

    public void printStart() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
    }

    public void askCoachName() {
        System.out.println(NEW_LINE + "코치의 이름을 입력해 주세요. (, 로 구분)");
    }

    public void askCantEatMenu(Coach coach) {
        System.out.println(String.format(NEW_LINE + "%s(이)가 못 먹는 메뉴를 입력해 주세요.", coach.getName()));
    }

    public void printResult(CategoryResult categoryResult) {
        System.out.println(NEW_LINE + "메뉴 추천 결과입니다.");
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
        System.out.println(format(categoryResult));
    }

    private static String format(CategoryResult categoryResult) {
        List<String> names = new ArrayList<>();
        for (Category category : categoryResult.getCategoryResults()) {
            names.add(category.getName());
        }
        return "[ 카테고리 | " + String.join(" | ", names) + " ]";
    }

    public void printError(String message) {
        System.out.println(message);
    }
}
