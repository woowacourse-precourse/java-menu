package menu.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final InputView instance = new InputView();

    public static InputView getInstance() {
        return instance;
    }

    private InputView() {
    }

    // static이면 이 위에 지우고 아래를 static으로 만들면됨

    public String readMainOption() {
        System.out.println(Message.INPUT_MAIN_OPTION.message);
        String input = Console.readLine();
        return input;
    }


    private enum Message {
        INPUT_MAIN_OPTION("메인 옵션");

        private final String message;

        Message(String message) {
            this.message = message;
        }
    }
}