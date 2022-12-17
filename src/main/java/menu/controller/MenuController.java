package menu.controller;

import menu.domain.category.Category;
import menu.domain.coach.Coach;
import menu.domain.draw.CategoryDraw;
import menu.domain.draw.MenuDraw;
import menu.domain.factory.CoachCreator;
import menu.domain.menu.Menu;
import menu.domain.menu.MenuRepository;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MenuController {
    private final InputView inputView;
    private final OutputView outputView;
    
    public MenuController() {
        inputView = new InputView();
        this.outputView = new OutputView();
    }
    
    public void run() {
        outputView.printApplicationStartGuide();
        List<Coach> coaches = inputView.repeatInput(() -> CoachCreator.from(inputView.inputCoachNames(outputView)), outputView);
        
        for (Coach coach : coaches) {
            List<Menu> uneatableMenus = inputView.repeatInput(() -> addUneatableMenus(coach), outputView);
            System.out.println(uneatableMenus);
        }
    }
    
    private List<Menu> addUneatableMenus(Coach coach) {
        String menusString = inputView.inputUneatableMenu(outputView, coach.name());
        List<String> menuNames = Arrays.stream(menusString.split(","))
                .collect(Collectors.toUnmodifiableList());
        
        List<Menu> uneatableMenus = new ArrayList<>();
        for (String menuName : menuNames) {
            Menu menu = MenuRepository.findByMenuName(menuName);
            uneatableMenus.add(menu);
        }
        return uneatableMenus;
    }
}
