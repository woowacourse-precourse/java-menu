package menu.view;

import menu.message.NoticeMessage;

public class OutputView {

    public void printServiceStartNotice() {
        System.out.println(NoticeMessage.SERVICE_START_NOTICE + '\n');
    }

    public void printCoachNameInputNotice() {
        System.out.println(NoticeMessage.COACH_NAME_INPUT_NOTICE + '\n');
    }

    public void printDislikeFoodInputNotice(String coachName) {
        System.out.println(coachName + NoticeMessage.DISLIKE_FOOD_INPUT_NOTICE + '\n');
    }

    public void printServiceEndNotice() {
        System.out.println(NoticeMessage.SERVICE_END_NOTICE + '\n');
    }
}
