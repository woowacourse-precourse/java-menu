package menu.view;

import java.util.List;
import menu.model.Category;
import menu.model.Coach;

public class Outputview {
    private static final String START_MESSAGE = "점심 메뉴 추천을 시작합니다.";
    private static final String BAR = " | ";
    private static final String RESULT_MESSAGE = "\n메뉴 추천 결과입니다.\n[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]";
    private static final String FINAL_MESSAGE = "추천을 완료했습니다.";
    private static final String EACH_LINE_OPEN = "[ ";
    private static final String EACH_LINE_CLOSE = " ]";

    public void printStart() {
        System.out.println(START_MESSAGE);
    }

    public void printResult(List<Coach> coachList, List<Category> categories) {
        System.out.println(RESULT_MESSAGE);
        printCategory(categories);
        for (Coach coach : coachList) {
            printCoach(coach);
        }
        System.out.println(FINAL_MESSAGE);
    }

    private void printCategory(List<Category> categories) {
        StringBuilder categoryMessage = new StringBuilder(EACH_LINE_OPEN + "카테고리" + BAR);
        for (Category category : categories) {
            categoryMessage.append(category.getName() + BAR);
        }
        int index = categoryMessage.lastIndexOf(BAR);
        String categoryFinal = categoryMessage.substring(0, index);
        System.out.println(categoryFinal.concat(EACH_LINE_CLOSE));
    }

    private void printCoach(Coach coach) {
        StringBuilder coachMessage = new StringBuilder(EACH_LINE_OPEN + coach.getName() + BAR);
        coach.getRecommended().stream().forEach(v -> coachMessage.append(v.getName() + BAR));
        int index = coachMessage.lastIndexOf(BAR);
        String coachFinal = coachMessage.substring(0, index);
        System.out.println(coachFinal.concat(EACH_LINE_CLOSE));
    }
}
