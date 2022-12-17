package menu.controller;

import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Menu;
import menu.service.CategoryService;
import menu.service.CoachService;
import menu.service.MenuService;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.List;

public class MenuController extends Controller{

    private final CoachService coachService = new CoachService();
    private final CategoryService categoryService = new CategoryService();
    private final MenuService menuService = new MenuService();

    public MenuController(InputView inputView, OutputView outputView) {
        super(inputView, outputView);
    }


    @Override
    public void run() {
        start();
        generateCoachList();
        inputHateMenus();
        recommendMenus();

    }

    public void start() {
        outputView.printStartMessage();
    }

    public void generateCoachList() {
        List<String> coaches = repeat(inputView::readCoaches);
        coaches.forEach(coach -> coachService.addCoach(coach));
    }

    public List<Coach> inputHateMenus() {
        List<Coach> coaches = coachService.findAll();
        for (Coach coach : coaches) {
            outputView.printCoachNamesInputMessage(coach.getName());
            List<Menu> hateMenus = repeat(inputView::readHateMenus);
            coachService.inputHateMenus(coach, hateMenus);
        }

        return coaches;
    }

    public void recommendMenus() {
        List<Category> categories = categoryService.getFiveCategories();
        List<Coach> coaches = coachService.findAll();
        menuService.recommendMenus(categories, coaches);
    }




}
