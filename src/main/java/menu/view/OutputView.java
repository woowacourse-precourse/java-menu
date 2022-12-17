package menu.view;

import static java.text.MessageFormat.format;

import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Coaches;
import menu.domain.Day;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String START_MESSAGE = "점심 메뉴 추천을 시작합니다.";
    private static final String ERROR_PREFIX = "[ERROR] ";

    public void printStart() {
        System.out.println(START_MESSAGE);
        System.out.println();
    }

    public void printError(String message) {
        System.out.println(ERROR_PREFIX + message);
    }

    public void printCoachCantEat(String name) {
        System.out.println(name + "(이)가 못 먹는 메뉴를 입력해 주세요.");
    }

    public void printRecommendResult(List<Category> categories, List<Coach> coaches) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("메뉴 추천 결과입니다." + System.lineSeparator());

        String pattern1 = "[ 구분 | {0} ]";
        String format1 = format(pattern1, Arrays.stream(Day.values())
                .map(Day::getDay)
                .collect(Collectors.joining(" | ")));
        stringBuilder.append(format1 + System.lineSeparator());

        String pattern2 = "[ 카테고리 | {0} ]";
        String format2 = format(pattern2, categories.stream()
                .map(Category::getName)
                .collect(Collectors.joining(" | ")));
        stringBuilder.append(format2 + System.lineSeparator());

        String pattern3 = "[ {0} | {1} ]";
        for (Coach coach : coaches) {
            String name = coach.getName();
            String recommendedMenus = coach.getRecommendedMenus().stream()
                    .collect(Collectors.joining(" | "));
            String format3 = format(pattern3, name, recommendedMenus);
            stringBuilder.append(format3 + System.lineSeparator());
        }

        System.out.println(stringBuilder.toString());
    }

    public void printEnd() {
        System.out.println("추천을 완료했습니다.");
    }
}
