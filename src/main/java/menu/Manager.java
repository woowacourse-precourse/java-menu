package menu;

import menu.controller.Controller;
import menu.domain.Status;
import menu.util.StandardRandomGenerator;
import menu.view.IOViewResolver;
import menu.view.InputView;
import menu.view.OutputView;

public class Manager {
    private static final Status INITIAL_STATUS = Status.READ_NAMES;

    private Manager() {

    }

    public static void run() {
        IOViewResolver ioViewResolver = new IOViewResolver(InputView.getInstance(), OutputView.getInstance());
        Controller controller = new Controller(ioViewResolver, new StandardRandomGenerator());
        Status status = INITIAL_STATUS;

        while (status != Status.EXIT) {
            status = controller.run(status);
        }
    }
}
