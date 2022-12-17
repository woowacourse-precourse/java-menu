package menu.view;

import menu.message.NoticeMessage;

public class OutputView {

    public void printServiceStartNotice() {
        System.out.println(NoticeMessage.SERVICE_START_NOTICE + '\n');
    }

    public void printServiceEndNotice() {
        System.out.println(NoticeMessage.SERVICE_END_NOTICE + '\n');
    }
}
