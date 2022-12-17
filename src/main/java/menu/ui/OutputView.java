package menu.ui;

import java.util.List;
import java.util.stream.Collectors;
import menu.domain.Category;
import menu.domain.Coach;

public class OutputView {

    public static final String NEW_LINE = "\n";

    public static void start() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
    }

    public static void enterCoach() {
        System.out.println(NEW_LINE + "코치의 이름을 입력해 주세요. (, 로 구분)");
    }

    public static void error(String message) {
        System.out.println("[ERROR]" + message);
    }

    public static void cantEatMenu(Coach coach) {
        System.out.println(NEW_LINE + coach.print() + "(이)가 못 먹는 메뉴를 입력해 주세요.");
    }

    public static void finish() {
        System.out.println(NEW_LINE + "추천을 완료했습니다.");
    }

    public static void result(List<Coach> coaches, List<Category> randomCategories, List<List<String>> result) {
        System.out.println(NEW_LINE + "메뉴 추천 결과입니다." +
                NEW_LINE + "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
        System.out.println("[ 카테고리 | " + randomCategories.stream()
                .map(Category::printName)
                .collect(Collectors.joining(" | ")) + " ]");
        for (int i = 0; i < coaches.size(); i++) {
            System.out.print("[ " + coaches.get(i).print() + " | ");
            printCategoryMenus(result, i);
            System.out.println(" ]");
        }
    }

    private static void printCategoryMenus(List<List<String>> result, int i) {
        for (int j = 0; j < result.size(); j++) {
            if (j == result.size() - 1) {
                System.out.print(result.get(j).get(i));
                break;
            }
            System.out.print(result.get(j).get(i) + " | ");
        }
    }
}
