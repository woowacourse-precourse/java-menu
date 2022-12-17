package menu.view;

import menu.dto.WeekMenusDto;

import java.util.List;

public class OutputView {
    private final String MESSAGE_START= "점심 메뉴 추천을 시작합니다.";
    private final String MESSAGE_RESULT = "메뉴 추천 결과입니다.";
    private final String MESSAGE_DAY_WEEK = "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]";
    private final String MESSAGE_CATEGORY_FORMAT = "[ 카테고리 | %s | %s | %s | %s | %s ]\n";
    private final String MESSAGE_WEEK_MENU_FORMAT = "[ %s | %s | %s | %s | %s | %s ]\n";
    private final String MESSAGE_FINISH = "추천을 완료했습니다.";

    public void printStartMessage() {
        System.out.println(MESSAGE_START);
    }

    public void printMenuResult(List<String> categories, List<WeekMenusDto> weekMenus) {
        System.out.println(MESSAGE_RESULT);
        System.out.println(MESSAGE_DAY_WEEK);
        System.out.printf(MESSAGE_CATEGORY_FORMAT, categories.get(0), categories.get(1), categories.get(2), categories.get(3), categories.get(4));
        for (WeekMenusDto weekMenu : weekMenus) {
            List<String> menus = weekMenu.getMenus();
            System.out.printf(MESSAGE_WEEK_MENU_FORMAT, weekMenu.getCoachName(), menus.get(0), menus.get(1), menus.get(2), menus.get(3), menus.get(4));
        }
    }

    public void printFinishMessage() {
        System.out.println(MESSAGE_FINISH);
    }
}
