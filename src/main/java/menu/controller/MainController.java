package menu.controller;

import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.CoachRepository;
import menu.domain.NoEatMenu;
import menu.service.MenuService;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MainController extends AbstractController {

    private final InputView inputView;
    private final OutputView outputView;
    private final MenuService menuService;

    public MainController(InputView inputView, OutputView outputView, MenuService menuService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.menuService = menuService;
    }

    @Override
    void doProcess() {
        outputView.printFeatures();
        NoEatMenu noEatMenu = askAboutFoodCoachNoEat();
        List<Category> categories = menuService.recommendCategory();
        outputView.printRandomCategory(categories);
        outputView.printResult();
    }

    private NoEatMenu askAboutFoodCoachNoEat() {
        HashMap<Coach, List<String>> noEatMenuHash = new HashMap<>();
        for (Coach coach : CoachRepository.findAllCouch()) {
            outputView.printCantEatMenu(coach.getName());
            String[] strings = inputView.readNoEatMenu();
            noEatMenuHash.put(coach, Arrays.asList(strings));
        }
        return new NoEatMenu(noEatMenuHash);
    }

}
