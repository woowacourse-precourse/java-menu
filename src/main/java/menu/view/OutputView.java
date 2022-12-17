package menu.view;

import java.util.Arrays;
import java.util.List;
import menu.model.enums.Category;
import menu.model.Coach;
import menu.model.enums.Days;

public class OutputView {
    private static final String START_MESSAGE = "점심 메뉴 추천을 시작합니다.";
    private static final String BAR = " | ";
    private static final String RESULT_MESSAGE = "\n메뉴 추천 결과입니다.";
    private static final String FINAL_MESSAGE = "\n추천을 완료했습니다.";
    private static final String DAYS_START = "구분";
    private static final String CATEGORY_START = "카테고리";
    private static final String EACH_LINE_OPEN = "[ ";
    private static final String EACH_LINE_CLOSE = " ]";

    public void printStart() {
        System.out.println(START_MESSAGE);
    }

    public void printResult(List<Coach> coachList, List<Category> categories) {
        System.out.println(RESULT_MESSAGE);
        printDays();
        printCategory(categories);
        coachList.stream().forEach(this::printCoach);
        System.out.println(FINAL_MESSAGE);
    }

    private void printCategory(List<Category> categories) {
        StringBuilder categoryMessage = new StringBuilder(EACH_LINE_OPEN + CATEGORY_START + BAR);
        for (Category category : categories) {
            categoryMessage.append(category.getName() + BAR);
        }
        printWithoutLastBAR(categoryMessage);
    }

    private void printDays() {
        StringBuilder daysResult = new StringBuilder(EACH_LINE_OPEN + DAYS_START + BAR);
        Arrays.stream(Days.values()).forEach(v -> daysResult.append(v.getName() + BAR));
        printWithoutLastBAR(daysResult);
    }

    private void printCoach(Coach coach) {
        StringBuilder coachMessage = new StringBuilder(EACH_LINE_OPEN + coach.getName() + BAR);
        coach.getRecommended().stream().forEach(v -> coachMessage.append(v.getName() + BAR));
        printWithoutLastBAR(coachMessage);
    }

    private void printWithoutLastBAR(StringBuilder sentence) {
        int index = sentence.lastIndexOf(BAR);
        String coachFinal = sentence.substring(0, index);
        System.out.println(coachFinal.concat(EACH_LINE_CLOSE));
    }
}
