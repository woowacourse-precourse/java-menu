package menu.util;

import java.util.List;
import menu.view.InputView;

public class InputExceptionHandler {
    InputView inputView = new InputView();

    public List<String> getCoachList() {
        while (true) {
            try {
                return inputView.getCoachList();
            } catch (IllegalArgumentException e) {
                return getCoachList();
            }
        }
    }

    public List<String> getHateList(String name) {
        while (true) {
            try {
                return inputView.getHateList(name);
            } catch (IllegalArgumentException e) {
                return getHateList(name);
            }
        }
    }

}
