package menu.service;

import menu.view.InputView;
import menu.view.OutputView;

import java.util.function.Supplier;

import static menu.constant.InputMessage.GET_COACH_NAME;

public class InputService {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    /**
     * 에러가 발생하면 다시 재입력을 받는 메서드.
     */
    public <T> T getUserInput(Supplier<T> inputReader) {
        try {
            return inputReader.get();
        } catch (IllegalArgumentException e) {
            outputView.printMessage(e.getMessage());
            return getUserInput(inputReader);
        }
    }

    public String[] getCoachNames() {
        outputView.printMessage(GET_COACH_NAME.getValue());
        return inputView.getCoachNames();
    }
}
