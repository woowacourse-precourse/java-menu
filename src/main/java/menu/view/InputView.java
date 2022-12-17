package menu.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.function.Supplier;

public class InputView {
    
    public String inputCoachNames(OutputView outputView) {
        outputView.printInputCoachNamesGuide();
        return Console.readLine();
    }
    
    public <T> T repeatInput(Supplier<T> inputProcess, OutputView outputView) {
        try {
            return inputProcess.get();
        } catch (IllegalArgumentException raisedException) {
            outputView.printErrorMessage(raisedException);
            return repeatInput(inputProcess, outputView);
        }
    }
}
