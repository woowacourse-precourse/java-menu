package menu;


import menu.domain.Coach;
import menu.domain.WeekMenus;
import menu.domain.Menu;
import menu.enums.Category;
import menu.repository.MenuRepository;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MenuRecommendController {

    private final InputView inputView;
    private final OutputView outputView;
    private final MenuRecommendService menuService = new MenuRecommendService();

    public MenuRecommendController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        outputView.printStartMessage();
        List<Coach> coaches = initCoaches();
        //카테고리 정하기
        List<Category> categories = CategoryPicker.pickMenuCategories();
        //요일마다 카테고리에 해당하는 메뉴들을 코치들에게 추천
        List<WeekMenus> menuResult = menuService.recommendMenus(coaches, categories);
        outputView.printMenuResult(categories.stream().map(Category::getName).collect(Collectors.toList()), menuResult.stream().map(WeekMenus::toDto).collect(Collectors.toList()));
        outputView.printFinishMessage();
    }

    private List<Coach> initCoaches() {
        List<Coach> coaches = new ArrayList<>();

        String[] coachNames = inputView.readCoachNames();
        for (int i = 0; i < coachNames.length; i++) {
            String[] excludeMenu = inputView.readExcludeMenu(coachNames[i]);
            List<Menu> excludeMenus = new ArrayList<>();

            for (String menuName: excludeMenu) {
                excludeMenus.add(MenuRepository.getMenuByName(menuName));
            }
            coaches.add(new Coach(coachNames[i], excludeMenus));
        }
        return coaches;
    }
}
