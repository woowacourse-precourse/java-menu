package menu.view;

import menu.domain.Categories;
import menu.domain.Crew;
import menu.domain.Crews;

public class OutputView {
    private final static String ERROR = "[ERROR] ";

    public void printStart() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
    }

    public void printRequestCrewsName() {
        System.out.println("\n코치의 이름을 입력해 주세요. (, 로 구분)");
    }

    public void printRequestOfBannedFoods(String crewName) {
        System.out.println("\n" + crewName + "(이)가 못 먹는 메뉴를 입력해 주세요.");
    }

    public void printResult(Categories categories, Crews crews) {
        System.out.println("\n메뉴 추천 결과입니다.");
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
        printCategories(categories);
        printFoodOfCrews(crews);
    }

    public void printCategories(Categories categories) {
        String printCategoryMap = "[ 카테고리 " + categories.toString() + " ]";
        System.out.println(printCategoryMap);
    }

    public void printFoodOfCrews(Crews crews) {

    }

    public static void printError(String message) {
        System.out.println(ERROR + message);
    }
}
