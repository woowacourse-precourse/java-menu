package menu.view;

import java.util.List;
import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Menu;
import menu.message.NoticeMessage;

public class OutputView {
    private static final String END_NOTICE_PREFIX = "[ ";
    private static final String END_NOTICE_SUFFIX = " ]";
    private static final String END_NOTICE_MIDFIX = " | ";

    public void printServiceStartNotice() {
        System.out.println(NoticeMessage.SERVICE_START_NOTICE);
    }

    public void printCoachNameInputNotice() {
        System.out.println('\n' + NoticeMessage.COACH_NAME_INPUT_NOTICE);
    }

    public void printDislikeFoodInputNotice(String coachName) {
        System.out.println('\n' + coachName + NoticeMessage.DISLIKE_FOOD_INPUT_NOTICE);
    }

    public void printServiceEndNotice(List<Category> categoryHistory , List<Coach> coaches) {
        StringBuilder endNotice = new StringBuilder(NoticeMessage.SERVICE_END_NOTICE_TOP).append('\n');

        endNotice.append(makeCategoryRecommendResult(categoryHistory)).append('\n');

        for (Coach coach : coaches) {
            endNotice.append(makeMenuRecommendResult(coach)).append('\n');
        }

        endNotice.append('\n').append(NoticeMessage.SERVICE_END_NOTICE_BOTTOM);

        System.out.println('\n' + endNotice.toString());
    }

    private String makeCategoryRecommendResult(List<Category> categoryHistory) {
        StringBuilder result = new StringBuilder();
        result.append(END_NOTICE_PREFIX);
        result.append("카테고리");

        for (int day = 0; day < 5; day++) {
            result.append(END_NOTICE_MIDFIX);
            result.append(categoryHistory.get(day).getName());
        }

        result.append(END_NOTICE_SUFFIX);

        return result.toString();
    }

    private String makeMenuRecommendResult(Coach coach) {
        StringBuilder result = new StringBuilder();
        result.append(END_NOTICE_PREFIX);

        result.append(coach.getName());

        List<String> recommendedMenus = coach.getRecommendedMenus();
        for (int day = 0; day < 5; day++) {
            result.append(END_NOTICE_MIDFIX);
            result.append(recommendedMenus.get(day));
        }

        result.append(END_NOTICE_SUFFIX);

        return result.toString();
    }
}
