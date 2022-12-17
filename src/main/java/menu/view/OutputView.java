package menu.view;

import menu.domain.Category;
import menu.domain.Coach;
import menu.utils.Notice;

import java.util.List;

import static menu.utils.Notice.*;

public class OutputView {
    public void start() {
        System.out.println(Notice.of(START));
        System.out.println(Notice.of(ENTER_COACH_NAME));
    }

    public void recommendResult(List<Coach> coaches, Category category) {
        System.out.println(Notice.of(RESULT));
        System.out.println(Notice.of(WEEK));
        System.out.println(category.categoryResult());
        for (Coach coach : coaches) {
            System.out.println(coach.recommendMenuResult());
        }
        System.out.println(Notice.of(END));
    }
}
