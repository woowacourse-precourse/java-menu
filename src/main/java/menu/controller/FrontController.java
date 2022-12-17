package menu.controller;

import menu.controller.exception.NotFoundCoachControllerLogicException;
import menu.controller.status.CoachControllerStatus;
import menu.view.front.FrontOutputView;

public class FrontController {

    private static final String APPLICATION_EXCEPTION_MESSAGE = "애플리케이션 실행 도중 문제가 발생했습니다.";

    private final CoachController coachController;
    private final MenuController menuController;
    private final FrontOutputView outputView;

    public FrontController(CoachController coachController, MenuController menuController,
            FrontOutputView outputView) {
        this.coachController = coachController;
        this.menuController = menuController;
        this.outputView = outputView;
    }

    public void run() {
        outputView.printStartGuideMessage();
        process();
        outputView.printEndGuideMessage();
    }

    private void process() {
        try {
            processCoachHandler();
            processMenuHandler();
        } catch (NotFoundCoachControllerLogicException e) {
            System.out.println(e.getMessage());
        } catch (StackOverflowError | OutOfMemoryError e) {
            System.out.println(APPLICATION_EXCEPTION_MESSAGE);
        }
    }

    private void processCoachHandler() {
        CoachControllerStatus status = CoachControllerStatus.INPUT_COACHES_NAME;

        while (status.isRunnable()) {
            status = coachController.process(status);
        }
    }

    private void processMenuHandler() {
        menuController.process();
    }
}
