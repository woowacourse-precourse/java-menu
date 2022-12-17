package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.dto.input.ReadNamesDto;

public class InputView {
    private InputView() {
    }

    private static class InputViewSingletonHelper {
        private static final InputView INPUT_VIEW = new InputView();
    }

    public static InputView getInstance() {
        return InputViewSingletonHelper.INPUT_VIEW;
    }


    public ReadNamesDto readNames() {
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
        return new ReadNamesDto(readUserInput());
    }

    private String readUserInput() {
        return Console.readLine();
    }
}
