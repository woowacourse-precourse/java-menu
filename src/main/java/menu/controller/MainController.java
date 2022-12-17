package menu.controller;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;
import menu.domain.Coach;
import menu.view.InputView;
import menu.view.OutputView;

public class MainController {
    private final InputView inputView;
    private final OutputView outputView;
    private final Map<ApplicationStatus, Supplier<ApplicationStatus>> gameGuide;

    public MainController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.gameGuide = new EnumMap<>(ApplicationStatus.class); // 밑에 status 있음
        initializeGameGuide();
    }

    private void initializeGameGuide() {
        gameGuide.put(ApplicationStatus.INITIALIZE_MENUS, this::initializeMenus);
        gameGuide.put(ApplicationStatus.RECEIVE_COACH_DATA, this::receiveCoachData);
    }


    public void play() {
        ApplicationStatus applicationStatus = process(ApplicationStatus.INITIALIZE_MENUS); // 초기 status
        while (applicationStatus.playable()) {
            applicationStatus = process(applicationStatus);
        }
    }

    public ApplicationStatus process(ApplicationStatus applicationStatus) {
        try {
            return gameGuide.get(applicationStatus).get();
        } catch (Exception exception) {
            return ApplicationStatus.APPLICATION_EXIT;
        }
    }

    private ApplicationStatus initializeMenus() {
        // 입력 하나 틀리면 다시 입력 => inputView에서 해결
        // 입력 검증하다가 틀리면 다시 입력 => ApplicationStatus를 리턴하는 방식
        return ApplicationStatus.RECEIVE_COACH_DATA;
    }

    private ApplicationStatus receiveCoachData() {
        outputView.printStart();
        Coach coach = new Coach("포비");
        return ApplicationStatus.APPLICATION_EXIT;
    }

    private enum ApplicationStatus {
        INITIALIZE_MENUS,
        RECEIVE_COACH_DATA,
        APPLICATION_EXIT;

        public boolean playable() {
            return this != APPLICATION_EXIT;
        }
    }

}