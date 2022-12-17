package menu.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import menu.util.Util;

public class InputView {

    private static final InputView instance = new InputView();

    public static InputView getInstance() {
        return instance;
    }

    private InputView() {
    }

    // static이면 이 위에 지우고 아래를 static으로 만들면됨

    public List<String> readCoachNames() {
        System.out.println(Message.INPUT_COACH_NAMES.message);
        List<String> coaches = Util.splitByComma(Console.readLine());
        // validate
        return coaches;
    }


    private enum Message {
        INPUT_COACH_NAMES("\n코치의 이름을 입력해 주세요. (, 로 구분)");

        private final String message;

        Message(String message) {
            this.message = message;
        }
    }
}