package menu.view;

import menu.model.CategoryResult;
import menu.model.Menu;
import menu.model.MenuResult;

import java.util.List;

public class OutputView {

    public static final String START_MESSAGE = "점심 메뉴 추천을 시작합니다.";
    public static final String READ_COACH_NAME_MESSAGE = "코치의 이름을 입력해 주세요. (, 로 구분)";
    public static final String READ_IMPOSSIBLE_MENUS_MESSAGE = "(이)가 못 먹는 메뉴를 입력해 주세요.";
    public static final String RESULT_INTRODUCTION_MESSAGE = "메뉴 추천 결과입니다.";
    public static final String TABLE_HEAD_MESSAGE = "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]";
    public static final String END_MESSAGE = "추천을 완료했습니다.";
    public static final String OPEN_EMBRACE = "[";
    public static final String CLOSE_EMBRACE = "]";
    public static final String SPACE = " ";
    public static final String CATEGORY_MESSAGE = "카테고리";
    public static final String DELIMITER = "|";

    private void printlnMessage(String message) {
        System.out.println(message);
    }

    private void printMessage(String message) {
        System.out.print(message);
    }

    public void printError(String message) {
        System.out.println(message);
    }

    public void printBlackLine() {
        printlnMessage("");
    }

    public void printStart() {
        printlnMessage(START_MESSAGE);
        printBlackLine();
    }

    public void printReadCoachNames() {
        printlnMessage(READ_COACH_NAME_MESSAGE);
    }

    public void printReadImpossibleMenus(String coachName) {
        printlnMessage(coachName + READ_IMPOSSIBLE_MENUS_MESSAGE);
    }

    public void printResultHead() {
        printlnMessage(RESULT_INTRODUCTION_MESSAGE);
        printlnMessage(TABLE_HEAD_MESSAGE);
    }

    public void printCategoryResult(CategoryResult categoryResult) {
        List<String> categoryResultList = categoryResult.getCategoryResult();
        printMessage(OPEN_EMBRACE);
        printMessage(SPACE + CATEGORY_MESSAGE + SPACE);
        for (int i = 0; i < categoryResultList.size(); i++) {
            printMessage(DELIMITER);
            printMessage(SPACE + categoryResultList.get(i) + SPACE);
        }
        printlnMessage(CLOSE_EMBRACE);
    }

    public void printMenuResult(MenuResult menuResult) {
        String coachName = menuResult.getCoachName();
        List<Menu> menuList = menuResult.getMenuList();
        printMessage(OPEN_EMBRACE);
        printMessage(SPACE + coachName + SPACE);
        for (int i = 0; i < menuList.size(); i++) {
            printMessage(DELIMITER);
            printMessage(SPACE + menuList.get(i).getMenuName() + SPACE);
        }
        printlnMessage(CLOSE_EMBRACE);
    }

    public void printEnd() {
        printlnMessage(END_MESSAGE);
    }
}
