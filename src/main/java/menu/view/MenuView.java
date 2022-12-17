package menu.view;

import menu.dto.CouchNamesRequest;

public class MenuView {
    private final InputView inputView;
    private final OutputView outputView;

    public MenuView(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void printStartMessage() {
        outputView.printStartMessage();
    }

    public CouchNamesRequest receiveCouches() {
        while (true) {
            try {
                String input = inputView.inputCouchName();
                System.out.println();
                return CouchNamesRequest.of(input);
            } catch (IllegalArgumentException e) {
                outputView.printException(e);
            }
        }
    }
}
