package menu.view;

import menu.domain.MenuDTO;

import java.util.stream.Collectors;

public class OutputView {
    private final String RESULT_MESSAGE = System.lineSeparator() + "메뉴 추천 결과입니다.";
    private final String WEEK_EXPRESSION = "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]";
    private final String SYSTEM_OVER_MESSAGE = System.lineSeparator() + "추천을 완료했습니다.";

    public void renderResult(MenuDTO menu) {
        System.out.println(RESULT_MESSAGE);
        System.out.println(WEEK_EXPRESSION);
        printCategories(menu);
        printMenusForEachCoach(menu);
        System.out.println(SYSTEM_OVER_MESSAGE);
    }

    private void printCategories(MenuDTO menu) {
        System.out.println(menu.getCategories().stream()
                .collect(Collectors.joining(" | ", "[ 카테고리 | ", " ]")));
    }

    private void printMenusForEachCoach(MenuDTO menu) {
        menu.getCoaches()
                .forEach(coach -> {
                    System.out.print("[ " + coach.getName() + " | ");
                    System.out.println(coach.getMenus().stream()
                            .collect(Collectors.joining(" | ", "", " ]")));
                });
    }

    public void printExceptionMessage(String message) {
        System.out.println(message);
    }
}
