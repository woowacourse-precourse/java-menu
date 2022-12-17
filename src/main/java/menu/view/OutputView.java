package menu.view;

import menu.message.NoticeMessage;

public class OutputView {
    public static final String NEW_LINE = "\n";

    public void outputStartNotice() {
        System.out.println(NoticeMessage.START_MESSAGE + NEW_LINE);
    }
}
