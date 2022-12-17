package menu.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    
    public String inputCoachNames(OutputView outputView) {
        outputView.printInputCoachNamesGuide();
        return Console.readLine();
    }
}
