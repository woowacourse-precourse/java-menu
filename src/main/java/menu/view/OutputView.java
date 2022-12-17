package menu.view;

import static menu.message.OutputMsg.*;

public class OutputView {

    public void printStart() {
        System.out.println(OUTPUT_MSG_SERVICE_START.get());
    }

    public void printMessage(String message) {
        System.out.print("\n" + message);
    }
}
