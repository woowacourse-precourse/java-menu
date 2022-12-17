package menu.view;

import java.util.Map;
import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.DayOfWeek;
import menu.domain.Menu;
import menu.domain.RecommendResult;
import menu.dto.CoachNameDto;

public class OutputView {
    private static final String PROGRAM_START_MESSAGE = "점심 메뉴 추천을 시작합니다.";
    private static final String READ_COACH_NAMES_MESSAGE = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private static final String READ_CANT_EAT_MENUS_MESSAGE = "(이)가 못 먹는 메뉴를 입력해 주세요.";
    private static final String RECOMMENDED_MENU_MESSAGE = "메뉴 추천 결과입니다.";
    private static final String FINISHED_MENU_MESSAGE = "추천을 완료했습니다.";
    private static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";
    private static final String DAY_OF_WEEKS = "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]";
    private static final String LINE_PREFIX = "[ ";
    private static final String LINE_POSTFIX = " ]";
    private static final String DELIMITER = " | ";

    public static void printException(Exception e) {
        System.out.println(ERROR_MESSAGE_PREFIX + e.getMessage());
    }

    public static void printProgramStartMessage() {
        System.out.println(PROGRAM_START_MESSAGE);
    }

    public static void printReadCoachNames() {
        System.out.println(READ_COACH_NAMES_MESSAGE);
    }

    public static void printReadCantEatMenus(CoachNameDto coachNameDto) {
        String name = coachNameDto.getName();
        System.out.println(name + READ_CANT_EAT_MENUS_MESSAGE);
    }

    public static void printRecommendedMenus(Map<Coach, RecommendResult> result) {
        System.out.println(RECOMMENDED_MENU_MESSAGE);
        printDayOfWeek();
        printCategories(result);
        for (Coach coach : result.keySet()) {
            System.out.print(LINE_PREFIX);
            System.out.print(coach.getName());
            printMenusOrderedByDayOfWeek(result.get(coach), coach);
            System.out.println(LINE_POSTFIX);
        }
        System.out.println(FINISHED_MENU_MESSAGE);
    }

    private static void printDayOfWeek() {
        System.out.println(DAY_OF_WEEKS);
    }

    private static void printCategories(Map<Coach, RecommendResult> result) {
        RecommendResult recommendResult = result.values().stream().findFirst().get();
        System.out.print(LINE_PREFIX + "카테고리");
        for (DayOfWeek dayOfWeek : DayOfWeek.values()) {
            System.out.print(DELIMITER);
            Category category = recommendResult.getMenus(dayOfWeek).getCategory();
            System.out.print(category.getName());
        }
        System.out.println(LINE_POSTFIX);
    }

    private static void printMenusOrderedByDayOfWeek(RecommendResult result, Coach coach) {
        for (DayOfWeek dayOfWeek : DayOfWeek.values()) {
            System.out.print(DELIMITER);
            Menu menu = result.getMenus(dayOfWeek);
            System.out.print(menu.getName());
        }
    }
}
