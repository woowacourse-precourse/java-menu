package menu.view;

import java.util.List;
import java.util.stream.Collectors;
import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Week;

public class OutputView {
    private static final String START = "점심 메뉴 추천을 시작합니다.";
    private static final String RECOMMEND_RESULT = "메뉴 추천 결과입니다.";
    private static final String FINISH = "추천을 완료했습니다.";
    public void startProgram() {
        System.out.println(START);
    }

    public void programResult(List<Coach> coaches, List<Week> weeks) {
        System.out.println(RECOMMEND_RESULT);
        System.out.println(Week.getWeekFormat());
        System.out.println(Category.getFormat(weeks));
        for(Coach coach : coaches) {
            System.out.println(coach.getFormat());
        }
        System.out.println(FINISH);
    }
}
