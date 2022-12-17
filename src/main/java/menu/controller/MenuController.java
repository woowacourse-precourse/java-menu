package menu.controller;

import menu.service.InitializationService;
import menu.service.ValidationService;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static menu.view.OutputView.printStartMessage;

public class MenuController {
    InitializationService initializationService;
    InputView inputView;
    OutputView outputView;

    public MenuController() {
        initializationService = new InitializationService();
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void run() {
        initializationService.initializeCategory();
        printStartMessage();

        List<String> coachNames = takeCoaches();
        takeMenuFromCoach(coachNames);

    }

    public List<String> takeCoaches() {
        String name = ValidationService.takeCoachNames();

        String[] splitNames = name.split(",");

        return Arrays.stream(splitNames)
                .collect(Collectors.toList());
    }

    public void takeMenuFromCoach(List<String> coachNames) {
        for (String coachName : coachNames) {
            String notEatMenu = ValidationService.takeNotEatMenus(coachName);

            String[] splitNames = notEatMenu.split(",");

            List<String> notEatMenus = Arrays.stream(splitNames)
                    .collect(Collectors.toList());
        }
    }
}
