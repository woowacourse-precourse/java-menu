package view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final OutputView outputView;

    public InputView(OutputView outputView) {
        this.outputView = outputView;
    }

    private String read() {
        return Console.readLine();
    }

    public String readCoachNames() {
        outputView.printReadingCoachNames();
        return read();
    }

    public String readNotAvailableFood(String coachName) {
        outputView.printReadingHateFood(coachName);
        return read();
    }
}
