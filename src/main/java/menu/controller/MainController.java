package menu.controller;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;
import menu.controller.subcontroller.CoachDataController;
import menu.controller.subcontroller.Controllable;
import menu.controller.subcontroller.InitializingController;
import menu.controller.subcontroller.MenuRecommendationController;
import menu.domain.status.ApplicationStatus;
import menu.view.InputView;
import menu.view.OutputView;

public class MainController {
    private final InputView inputView;
    private final OutputView outputView;
    private final Map<ApplicationStatus, Controllable> controllers;

    public MainController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.controllers = new EnumMap<>(ApplicationStatus.class);
        initializeControllers();
    }

    private void initializeControllers() {
        controllers.put(ApplicationStatus.INITIALIZE_MENUS, new InitializingController(inputView, outputView));
        controllers.put(ApplicationStatus.RECEIVE_COACH_DATA, new CoachDataController(inputView, outputView));
        controllers.put(ApplicationStatus.GIVE_RECOMMENDATION, new MenuRecommendationController(inputView, outputView));
    }

    public void play() {
        ApplicationStatus applicationStatus = process(ApplicationStatus.INITIALIZE_MENUS);
        while (applicationStatus.playable()) {
            applicationStatus = process(applicationStatus);
        }
    }

    public ApplicationStatus process(ApplicationStatus applicationStatus) {
        try {
            return controllers.get(applicationStatus).process();
        } catch (NullPointerException exception) {
            return ApplicationStatus.APPLICATION_EXIT;
        }
    }

}