package menu.ui.output;

import menu.domain.Category;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Output {
    private static final String SEPERATOR = " | ";
    private static final String FIRST_WRAPPER = "[ ";
    private static final String LAST_WRAPPER = " ]";
    private static final List<String> DAYS = Arrays.asList("월요일", "화요일", "수요일", "목요일", "금요일");
    private static final String CATEGORY = "카테고리";

    public void notifyInitializing() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
    }

    public void notifyEnding() {
        System.out.println("추천을 완료했습니다.");
    }

    public void printResult(List<Category> categoryHistory, List<List<String>> coachesHistory) {
        System.out.println("메뉴 추천 결과입니다.");
        printingForm(DAYS);
        printingForm(getCategoriesName(categoryHistory));
        for (List<String> coachHistory : coachesHistory) {
            printingForm(coachHistory);
        }
    }

    private void printingForm(List<String> data) {
        String result = String.join(SEPERATOR, data);
        System.out.println(FIRST_WRAPPER + result + LAST_WRAPPER);
    }

    private List<String> getCategoriesName(List<Category> categoryHistory) {
        List<String> result = new ArrayList<>();
        result.add(CATEGORY);

        for (Category category : categoryHistory) {
            result.add(category.getName());
        }

        return result;
    }
}
