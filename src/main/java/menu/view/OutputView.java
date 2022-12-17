package menu.view;

import menu.view.message.Message;

public class OutputView {

    public void printStart() {
        print(Message.START.getMessage());
    }

    public void printCoachNameInputGuide() {
        print(Message.COACH_NAME_GUIDE.getMessage());
    }

    public void printErrorMessage(String message) {
        print(message);
    }

    private void print(String message) {
        System.out.print(message);
    }
}