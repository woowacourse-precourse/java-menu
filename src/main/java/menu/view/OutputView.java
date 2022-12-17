package menu.view;

import menu.domain.Coach;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    public void renderResult(List<Coach> coaches, List<String> categories) {
        System.out.println("메뉴 추천 결과입니다.");
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");

        System.out.println(categories.stream()
                .collect(Collectors.joining(" | ", "[ 카테고리 | ", " ]")));

        coaches.stream()
                .forEach(coach -> {
                    System.out.print("[ " + coach.getName() + " | ");
                    System.out.println(coach.getMenus().stream()
                            .collect(Collectors.joining(" | ", "", " ]")));
                });

        System.out.println("추천을 완료했습니다.");
    }
}
