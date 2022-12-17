package menu.view;

import java.util.List;
import java.util.stream.Collectors;
import menu.domain.Category;
import menu.domain.Coach;

public class OutputView {

    private static final String PREFIX = "[ ";
    private static final String SEPARATOR = " | ";
    private static final String SUFFIX = " ]";

    private static final String OUTPUT_START = "점심 메뉴 추천을 시작합니다.";
    private static final String OUTPUT_RESULT = "메뉴 추천 결과입니다.";
    private static final String OUTPUT_DAYS = "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]";
    private static final String OUTPUT_END_RECOMMEND = "추천을 완료했습니다.";

    private static final String TITLE_CATEGORY = "카테고리";


    public static void printRun() {
        System.out.println(OUTPUT_START);
    }

    public static void printResult(List<Category> categories, List<Coach> coaches) {
        System.out.println(OUTPUT_RESULT);
        System.out.println(OUTPUT_DAYS);
        System.out.println(PREFIX + TITLE_CATEGORY + SEPARATOR + String.join(SEPARATOR, getCategoryNames(categories)) + SUFFIX);
        coaches.stream()
                .forEach(coach -> printResultByCoach(coach));
        System.out.println(OUTPUT_END_RECOMMEND);
    }

    private static void printResultByCoach(Coach coach) {
        System.out.println(PREFIX + coach.getName() + SEPARATOR + String.join(SEPARATOR, getRecommendFoods(coach)) + SUFFIX);
    }

    private static List<String> getCategoryNames(List<Category> categories) {
        return categories.stream()
                .map(category -> category.getKoreanName())
                .collect(Collectors.toList());
    }

    private static List<String> getRecommendFoods(Coach coach) {
        return coach.getRecommendFoods()
                .stream()
                .map(recommendFood -> recommendFood.getFoodName())
                .collect(Collectors.toList());
    }


}
