package menu.controller;

import menu.domain.Coach;
import menu.service.*;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class MenuControllerImpl implements MenuController {
    private final InputView inputView;
    private final OutputView outputView;
    private final CategoryService categoryService;
    private final CoachService coachService;
    private final RecommendMenuService recommendMenuService;

    public MenuControllerImpl() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.categoryService = new CategoryServiceImpl();
        printStart();
        this.coachService = new CoachServiceImpl(initCoachList());
        this.recommendMenuService = new RecommendMenuService();
    }

    public void run() {
        List<Coach> coaches = coachService.getCoaches();
        coaches.forEach(this::initRefuseMenu);
        List<String> categories = categoryService.getCategories();
        recommendMenuService.recommend(coaches, categories);
        printResult(categories, coaches);
    }

    private void printResult(List<String> categories, List<Coach> coaches) {
        outputView.printResult();
        outputView.printCategoryResult(categories);
        outputView.printRecommendMenus(coaches);
        outputView.printServiceExit();
    }

    private void initRefuseMenu(Coach coach) {
        outputView.printRequestRefuseMenu(coach);
        List<String> refuseMenu = inputView.readRefuseMenu();
        coachService.addRefuseMenuToCoach(coach, refuseMenu);
    }

    private List<Coach> initCoachList() {
        return inputView.readCoach()
                .stream().map(Coach::new)
                .collect(toList());
    }

    private void printStart() {
        outputView.printServiceStart();
        outputView.printRequestCoachName();
    }
}
