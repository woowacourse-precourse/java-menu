package menu.ui;

import menu.domain.Category;
import menu.domain.Coach;

import java.util.List;

public class OutputView {
    private final String START = "[ ";
    private final String END = " ]";
    private final String SECTION = " | ";

    private final String CATEGORY = "카테고리";
    private final String RESULT_MENU_RECOMMEND = "메뉴 추천 결과입니다.";
    private final String WEEK_SECTION = "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]";

    public void resultOfRecommend(List<Category> recommendedCategories, List<Coach> coaches) {
        System.out.println(RESULT_MENU_RECOMMEND);
        System.out.println(WEEK_SECTION);
        System.out.println(makeCategorySection(recommendedCategories));
        for (Coach coach : coaches) {
            System.out.println(makecoachSection(coach));
        }
        System.out.println("\n" + "추천을 완료했습니다.\n");
    }

    private String makeCategorySection(List<Category> recommendedCategories) {
        StringBuilder output = new StringBuilder(START + CATEGORY + SECTION);
        for (Category category :
                recommendedCategories) {
            output.append(category.getName()).append(SECTION);
        }
        output.replace(output.length() - 3, output.length(), "").append(END);
        return output.toString();
    }

    private String makecoachSection(Coach coach) {
        StringBuilder output = new StringBuilder(START + coach.getName() + SECTION);
        for (String food :
                coach.getRecommendedFoods()) {
            output.append(food).append(SECTION);
        }
        output.replace(output.length() - 3, output.length(), "").append(END);
        return output.toString();
    }
}
