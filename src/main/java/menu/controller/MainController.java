package menu.controller;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;
import menu.controller.subcontroller.CoachDataController;
import menu.controller.subcontroller.InitializingController;
import menu.controller.subcontroller.MenuRecommendationController;
import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Day;
import menu.domain.Menu;
import menu.domain.repository.CategoryRepository;
import menu.domain.repository.CoachRepository;
import menu.domain.status.ApplicationStatus;
import menu.view.InputView;
import menu.view.OutputView;

public class MainController {
    private final InputView inputView;
    private final OutputView outputView;
    private final Map<ApplicationStatus, Supplier<ApplicationStatus>> gameGuide;

    public MainController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.gameGuide = new EnumMap<>(ApplicationStatus.class);
        initializeGameGuide();
    }

    private void initializeGameGuide() {
        gameGuide.put(ApplicationStatus.INITIALIZE_MENUS, this::initializeMenus);
        gameGuide.put(ApplicationStatus.RECEIVE_COACH_DATA, this::receiveCoachData);
        gameGuide.put(ApplicationStatus.GIVE_RECOMMENDATION, this::giveRecommendation);
    }

    public void play() {
        ApplicationStatus applicationStatus = process(ApplicationStatus.INITIALIZE_MENUS);
        while (applicationStatus.playable()) {
            applicationStatus = process(applicationStatus);
        }
    }

    public ApplicationStatus process(ApplicationStatus applicationStatus) {
        try {
            return gameGuide.get(applicationStatus).get();
        } catch (NullPointerException exception) {
            return ApplicationStatus.APPLICATION_EXIT;
        }
    }

    private ApplicationStatus initializeMenus() {
        return new InitializingController(inputView, outputView).process();
    }

    private ApplicationStatus receiveCoachData() {
        return new CoachDataController(inputView, outputView).process();

    }

    private ApplicationStatus giveRecommendation() {
        return new MenuRecommendationController(inputView, outputView).process();

    }

}