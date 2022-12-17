package menu;

import java.text.MessageFormat;
import java.util.List;

public class OutputView {

    private static final String RESULT_MESSAGE = "메뉴 추천 결과압니다.";
    private static final String WEEK_MESSAGE = "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]";
    private static final String CATEGORY_MESSAGE = "[ 카테고리 | {0} | {1} | {2} | {3} | {4} ]";
    private static final String COACH_MEASSAGE = "[ {0} |";
    private static final String MENU_MESSAGE = " {1} | {2} | {3} | {4} | {5} ]";


    public void printResult(List<String> category, List<String> coach, List<List<String>> coachMenu) {
        System.out.println(RESULT_MESSAGE);
        System.out.println(WEEK_MESSAGE);
        System.out.println(MessageFormat.format(CATEGORY_MESSAGE, category.get(0), category.get(1), category.get(2), category.get(3),category.get(4)));
        for (int i = 0; i < coach.size(); i++) {
            System.out.print(MessageFormat.format(COACH_MEASSAGE, coach.get(i)));
            System.out.println(MessageFormat.format(MENU_MESSAGE, "코치이름", coachMenu.get(i).get(0), coachMenu.get(i).get(1), coachMenu.get(i).get(2), coachMenu.get(i).get(3),coachMenu.get(i).get(4)));
        }
        System.out.println();
    }
    public void printMessage(String message) {
        System.out.println(message);
    }
}
