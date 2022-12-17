package menu.service;

import menu.view.InputView;
import menu.view.OutputView;

import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Supplier;

import static menu.constant.InputMessage.GET_NOT_EAT_MENU;
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

    public <T, R> R getUserInputWithParam(Function<T, R> inputReader, T param) {
        try {
            return inputReader.apply(param);
        } catch (IllegalArgumentException e) {
            outputView.printMessage(e.getMessage());
            return getUserInputWithParam(inputReader, param);
        }
    }

    public List<String> getCoachNames() {
        outputView.printMessage(GET_COACH_NAME.getValue());
        return inputView.getCoachNames();
    }

    public List<String> getNotEatFoods(String coachName) {
        outputView.printMessage(String.format(GET_NOT_EAT_MENU.getValue(), coachName));
        return inputView.getNotEatFoods();
    }
}
