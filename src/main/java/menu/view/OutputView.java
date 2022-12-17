package menu.view;

import menu.view.constant.Prefix;

public class OutputView {
    private static class InstanceHolder {
        private static final OutputView INSTANCE = new OutputView();
    }

    private OutputView(){}

    public static OutputView getInstance() {
        return OutputView.InstanceHolder.INSTANCE;
    }

    public void printPhrase(String phrase) {
        System.out.println(phrase);
    }

    public void printErrorMessage(String message) {
        System.out.println(Prefix.ERROR.getPrefix() + message);
    }
}
