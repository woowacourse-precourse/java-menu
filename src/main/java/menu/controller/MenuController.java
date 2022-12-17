package menu.controller;

import menu.domain.Category;
import menu.domain.CategoryMenuReader;
import menu.domain.Coach;
import menu.domain.HateMenu;
import menu.domain.Menu;
import menu.domain.WeekCategory;
import menu.service.MenuService;
import menu.view.InputView;
import menu.view.OutputView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MenuController {

    private final static InputView inputView = InputView.getInstance();
    private final static OutputView outputView = OutputView.getInstance();

    private final CategoryMenuReader categoryMenuReader = CategoryMenuReader.getInstance();
    private static final String MENU_FILE_PATH = "java/src/category-menu.md";

    private static final List<MenuService> menuServiceGroup = new ArrayList<>();

    public void run() throws IOException {
        initialize();
        WeekCategory weekCategory = WeekCategory.getInstance();
        setMenuServiceGroup();
        outputView.printResult();
        outputView.printDays();
        outputView.printCategory(weekCategory);
        for (MenuService menuService : menuServiceGroup) {
            List<String> menus = menuService.recommendMenusOfWeek(weekCategory);
            outputView.printMenus(menus, menuService.getCoachName());
        }
        outputView.printQuit();
    }

    private void initialize() throws IOException {
        outputView.printStart();
        Map<Category, List<String>> fileContent = categoryMenuReader.readCategoryMenus(MENU_FILE_PATH);
        Menu.initialize(fileContent);
    }

    private void setMenuServiceGroup() {
        List<Coach> coaches = getCoaches();
        for(Coach coach : coaches){
            String name = coach.getName();
            HateMenu hateMenu = getHateMenuOf(name);
            MenuService menuService = new MenuService(coach, hateMenu);
            menuServiceGroup.add(menuService);
        }
    }

    private List<Coach> getCoaches() {
        List<String> names = inputView.readCoaches();
        return names.stream()
                .map(Coach::new)
                .collect(Collectors.toUnmodifiableList());
    }

    private HateMenu getHateMenuOf(String coach) {
        List<String> menuNames = inputView.readHateMenuOf(coach);
        List<Menu> menus = menuNames.stream()
                .map(Menu::valueOf)
                .collect(Collectors.toUnmodifiableList());
        return new HateMenu(menus);
    }


}
