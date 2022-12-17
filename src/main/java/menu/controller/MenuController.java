package menu.controller;

import static menu.domain.CoachRepository.saveCoach;
import static menu.service.RandomCategoriesMaker.findRandomCategory;
import static menu.service.RandomMenusMaker.findMenu;
import static menu.view.OutputView.printStartMessage;

import menu.domain.Coach;
import menu.domain.CoachRepository;
import menu.domain.RecommendationMenu;
import menu.domain.RecommendationMenuRepository;
import menu.service.InitializationService;
import menu.service.ValidationService;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

        takeRandoms(coachNames);
    }

    public List<String> takeCoaches() {
        String name = ValidationService.takeCoachNames();

        String[] splitNames = name.split(",");

        saveCoaches(splitNames);

        return Arrays.stream(splitNames)
                .collect(Collectors.toList());
    }

    public void takeMenuFromCoach(List<String> coachNames) {
        for (String coachName : coachNames) {
            String notEatMenu = ValidationService.takeNotEatMenus(coachName);

            String[] splitNames = notEatMenu.split(",");
            List<String> notEatMenus = Arrays.stream(splitNames)
                    .collect(Collectors.toList());

            saveNotEatFoodEachCoach(notEatMenus, coachName);
        }
    }

    public void saveCoaches(String[] names) {
        for (String name : names) {
            Coach coach = new Coach(name);

            CoachRepository.addCoach(coach);
        }
    }

    public void saveNotEatFoodEachCoach(List<String> notEatMenus, String coachName) {
        Coach coach = CoachRepository.findCoachByName(coachName);

        for (String notEatMenu : notEatMenus) {
            coach.addNotEatFood(notEatMenu);
        }

        saveCoach(coach);
    }

    public void takeRandoms(List<String> coachNames) {
        List<String> randomCategories = findRandomCategory();
        findMenu(coachNames, randomCategories);
    }
}
