package menu.controller;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import menu.domain.Category;
import menu.domain.CategoryRepository;
import menu.domain.Coach;
import menu.domain.CoachRepository;
import menu.domain.Day;
import menu.domain.Menu;
import menu.domain.MenuRepository;
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
        gameGuide.put(ApplicationStatus.START_RECOMMENDATION, this::startRecommendation);
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
        } catch (NullPointerException exception) {
            return ApplicationStatus.APPLICATION_EXIT;
        }
    }

    private ApplicationStatus initializeMenus() {
        new InitializingController().process();
        return ApplicationStatus.RECEIVE_COACH_DATA;
    }

    private ApplicationStatus receiveCoachData() {
        outputView.printStart();
        inputView.readCoachNames().forEach(CoachRepository::add);
        System.out.println(MenuRepository.menus());
        for (Coach coach : CoachRepository.coaches()) {
            List<Menu> menuNotToEat = inputView.readMenuNotToEat(coach.getName());
            coach.addMenuNotToEat(menuNotToEat);
        }
        return ApplicationStatus.START_RECOMMENDATION;
    }

    private ApplicationStatus startRecommendation() {
        for (Day day : Day.values()) {
            Category category = pickAvailableCategory();
            for (Coach coach : CoachRepository.coaches()) {
                Menu menu = pickAvailableMenu(coach, category);
                coach.addMenuAlreadyEaten(day, menu);
            }
            CategoryRepository.addCategoryCount(category);
        }
        outputView.printRecommendedMenus(CategoryRepository.getCategoriesAlreadyEaten(), CoachRepository.coaches());
        outputView.printFinishRecommendation();
        return ApplicationStatus.APPLICATION_EXIT;
    }

    private Category pickAvailableCategory() {
        Category category = CategoryRepository.pickRandomCategory();
        if (!CategoryRepository.isAvailableCategory(category)) {
            return pickAvailableCategory();
        }
        return category;
    }

    private Menu pickAvailableMenu(Coach coach, Category category) {
        Menu menu = category.pickRandomMenu();
        if (!coach.isAvailableMenu(menu)) {
            return pickAvailableMenu(coach, category);
        }
        return menu;
    }

    private enum ApplicationStatus {
        INITIALIZE_MENUS,
        RECEIVE_COACH_DATA,
        START_RECOMMENDATION,
        APPLICATION_EXIT;

        public boolean playable() {
            return this != APPLICATION_EXIT;
        }
    }

}