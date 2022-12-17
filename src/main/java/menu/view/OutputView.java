package menu.view;

import java.util.List;
import java.util.Map.Entry;
import menu.dto.response.CoachesWeeklyMenu;

public class OutputView {

    private static final String DELIMITER = " | ";
    private static final String MESSAGE_PREFIX = "[ ";
    private static final String MESSAGE_SUFFIX = " ] ";

    public void printAppRunMessage() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
    }

    public void printWeeklyRecommendMenu(CoachesWeeklyMenu coachesWeeklyMenu) {
        System.out.println("메뉴 추천 결과입니다.");
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
        printWeeklyMenuCategories(coachesWeeklyMenu);
        coachesWeeklyMenu.getEachCoachesMenu()
                .entrySet()
                .forEach(this::printEachCoachesWeeklyMenu);
        System.out.println("\n추천을 완료했습니다.");
    }

    private void printWeeklyMenuCategories(CoachesWeeklyMenu coachesWeeklyMenu) {
        String categories = String.join(DELIMITER, coachesWeeklyMenu.getCategoriesNames());
        System.out.println(MESSAGE_PREFIX + "카테고리 " + DELIMITER + categories + MESSAGE_SUFFIX);
    }

    private void printEachCoachesWeeklyMenu(Entry<String, List<String>> entry) {
        String menus = String.join(DELIMITER, entry.getValue());
        System.out.println(MESSAGE_PREFIX + entry.getKey() + DELIMITER + menus + MESSAGE_SUFFIX);
    }
}
