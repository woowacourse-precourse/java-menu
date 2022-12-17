package menu;

import menu.view.OutputView;

public interface TryCatchTemplate<T> {
    static <T> T repeatToRunWhileValid(TryCatchCallback<T> callback) {
        while (true) {
            try {
                return callback.run();
            } catch (IllegalArgumentException e) {
                OutputView.printExceptionMessageForInvalidInput(e.getMessage());
            }
        }
    }
}
