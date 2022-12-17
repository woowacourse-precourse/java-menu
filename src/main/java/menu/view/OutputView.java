package menu.view;

import menu.model.Category;
import menu.model.Coach;

import java.util.List;

public class OutputView {

    public static void printStartMessage() {
        printMessage("점심 메뉴 추천을 시작합니다.");
    }

    public static void requestCoachNames() {
        printMessage("코치의 이름을 입력해 주세요. (, 로 구분)");
    }

    public static void requestUnwantedMenu(String name) {
        printMessage(name + "(이)가 못 먹는 메뉴를 입력해 주세요.");
    }

    public static void printResult(List<Coach> coaches, List<Category> categories) {
        printMessage("메뉴 추천 결과입니다.");
        printMessage("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
        printCategories(categories);
        for (int i = 0; i < coaches.size(); i++) {
            printMessage(coaches.get(i).toString());
        }
        printMessage("추천을 완료했습니다.");
    }

    private static void printCategories(List<Category> categories) {
        String str = "[ 카테고리 | ";
        for (int i = 0; i < categories.size(); i++) {
            str += categories.get(i);
            if (i != categories.size() - 1)
                str += " | ";
        }
        str += " ]";

        printMessage(str);
    }

    private static void printMessage(String msg){
        System.out.println(msg);
    }
}
