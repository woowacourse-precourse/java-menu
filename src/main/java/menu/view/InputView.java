package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.validator.view.InputCommonValidator;

import java.util.function.Supplier;

public class InputView {
    
    public String inputCoachNames(OutputView outputView) {
        outputView.printInputCoachNamesGuide();
        String inputCoachNames = input();
        InputCommonValidator.validate(inputCoachNames);
        return inputCoachNames;
    }
    
    public String inputUneatableMenu(OutputView outputView, String coachName) {
        outputView.printInputUneatableMenuGuide(coachName);
    
        String inputUneatableMenu = input();
        InputCommonValidator.validate(inputUneatableMenu);
        return inputUneatableMenu;
    }
    
    private String input() {
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
