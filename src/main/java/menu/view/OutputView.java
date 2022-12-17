package menu.view;

public class OutputView {
    private static class InstanceHolder {
        private static final OutputView INSTANCE = new OutputView();
    }

    private OutputView(){}

    public static OutputView getInstance() {
        return OutputView.InstanceHolder.INSTANCE;
    }
}
