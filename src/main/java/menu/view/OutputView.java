package menu.view;

import java.util.List;
import menu.domain.Coach;
import menu.domain.Menu;
import menu.message.NoticeMessage;

public class OutputView {
    private static final String END_NOTICE_PREFIX = "[ ";
    private static final String END_NOTICE_SUFFIX = " ]";
    private static final String END_NOTICE_MIDFIX = " | ";

    public void printServiceStartNotice() {
        System.out.println(NoticeMessage.SERVICE_START_NOTICE + '\n');
    }

    public void printCoachNameInputNotice() {
        System.out.println(NoticeMessage.COACH_NAME_INPUT_NOTICE);
    }

    public void printDislikeFoodInputNotice(String coachName) {
        System.out.println(coachName + NoticeMessage.DISLIKE_FOOD_INPUT_NOTICE);
    }

    public void printServiceEndNotice(List<Coach> coaches) {
        StringBuilder endNotice = new StringBuilder(NoticeMessage.SERVICE_END_NOTICE_TOP).append('\n');

        for (Coach coach : coaches) {
            endNotice.append(makeRecommendResult(coach)).append('\n');
        }

        endNotice.append(NoticeMessage.SERVICE_END_NOTICE_BOTTOM);

        System.out.println(endNotice);
    }

    private String makeRecommendResult(Coach coach) {
        StringBuilder result = new StringBuilder();
        result.append(END_NOTICE_PREFIX);

        result.append(coach.getName());

        List<Menu> recommendedMenus = coach.getRecommendedMenus();
        for (int day = 0; day < 5; day++) {
            result.append(END_NOTICE_MIDFIX);
            result.append(recommendedMenus.get(day));
        }

        result.append(END_NOTICE_SUFFIX);

        return result.toString();
    }
}
