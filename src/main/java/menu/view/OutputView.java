package menu.view;

import menu.domain.Coach;
import menu.domain.Food;
import menu.domain.Group;
import menu.domain.enums.Category;
import menu.domain.enums.Weekday;

import java.util.List;

import static java.lang.String.format;
import static java.util.stream.Collectors.joining;

public class OutputView {

    private static final String START_RECOMMEND = "점심 메뉴 추천을 시작합니다.";
    private static final String BAR = " | ";
    private static final String RECOMMEND_RESULT = "메뉴 추천 결과입니다.";
    private static final String END_RECOMMEND = "추천을 완료했습니다.";

    private static final String DIVISION_FORMAT = "[ 구분 | %s ]";
    private static final String CATEGORY_FORMAT = "[ 카테고리 | %s ]";
    private static final String COACH_RECOMMENDED_FOOD_FORMAT = "[ %s | %s ]";

    public static void printRecommendStart() {
        System.out.println(START_RECOMMEND);
    }

    public static void printRecommendResult(final Group group) {
        System.out.println(RECOMMEND_RESULT);
        printDivision();
        printCategory(group.categories());
        printRecommends(group);
        System.out.println(END_RECOMMEND);
    }

    private static void printDivision() {
        String days = Weekday.weekdays()
                .stream()
                .map(Weekday::dayName)
                .collect(joining(BAR));
        String message = format(DIVISION_FORMAT, days);
        System.out.println(message);
    }


    private static void printCategory(final List<Category> categories) {
        String category = categories.stream()
                .map(Category::categoryName)
                .collect(joining(BAR));
        String message = format(CATEGORY_FORMAT, category);
        System.out.println(message);
    }

    private static void printRecommends(final Group group) {
        for (Coach coach : group.coaches()) {
            String menus = coach.recommends().stream()
                    .map(Food::name)
                    .collect(joining(BAR));
            String message = format(COACH_RECOMMENDED_FOOD_FORMAT, coach.name(), menus);
            System.out.println(message);
        }
    }
}
