package menu.controller;

import menu.service.InitializationService;
import menu.service.ValidationService;
import menu.view.InputView;
import menu.view.OutputView;

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

        takeCoaches();
    }

    public void takeCoaches() {
        String name = ValidationService.takeCoachNames();

        System.out.println(name);
    }
}
