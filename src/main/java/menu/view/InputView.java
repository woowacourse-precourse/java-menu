package menu.view;

public class InputView {
    private static class InstanceHolder {
        private static final InputView INSTANCE = new InputView();
    }
    
    private InputView(){}

    public static InputView getInstance() {
        return InputView.InstanceHolder.INSTANCE;
    }
}
