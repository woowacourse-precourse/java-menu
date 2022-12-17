package menu.view;

import java.util.List;

import menu.domain.Coach;

public class OutputView {
    private static final String SEPARATOR = " | ";

    public void printMenus(List<Coach> coaches) {
        System.out.println("메뉴 추천 결과입니다.");
        printElements("구분", List.of("월요일", "화요일", "수요일", "목요일", "금요일"));
        printElements("카테고리", List.of("뽑힌", "카테고리", "들"));
        printElements("코치이름", List.of("월요일메뉴", "화요일메뉴", "수", "목", "금"));
        System.out.println("추천을 완료했습니다.");
    }

    private void printElements(String name, List<String> elements) {
        String joinedElements = String.join(SEPARATOR, elements);
        System.out.printf("[ %s ]\n", String.join(SEPARATOR, name, joinedElements));
    }
}
