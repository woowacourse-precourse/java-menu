package menu.controller;

import java.util.List;
import menu.config.MenuConfig;
import menu.domain.Coach;
import menu.dto.Recommendation;
import menu.repository.HardToEatRepository;
import menu.repository.MenuRepository;
import menu.service.MenuService;
import menu.utils.MenuValidator;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final MenuService menuService = new MenuService();

    public void process() {
        initConfig();
        List<Coach> coaches = inputCoaches();
        processHardToEatMenus(coaches);
        processMenuRecommendation(coaches);
    }

    private void initConfig() {
        MenuRepository.clear();
        HardToEatRepository.clear();
        MenuConfig.configure();
    }

    private List<Coach> inputCoaches() {
        outputView.printServiceStart();
        outputView.printInputCoach();
        return inputView.readCoaches();
    }

    private void processHardToEatMenus(List<Coach> coaches) {
        for (Coach coach : coaches) {
            outputView.printHardToEat(coach);
            List<String> menus = inputView.readHardToEat();
            storeHardToEatMenus(coach, menus);
        }
    }

    private void storeHardToEatMenus(Coach coach, List<String> menus) {
        for (String menu : menus) {
            HardToEatRepository.addMenus(coach, menu);
        }
    }

    private void processMenuRecommendation(List<Coach> coaches) {
        try {
            Recommendation recommendation = getRecommendation(coaches);
            MenuValidator.validate(recommendation);
            outputView.printRecommendation(recommendation, coaches);
        } catch (IllegalStateException e) {
            processMenuRecommendation(coaches);
        }
    }

    private Recommendation getRecommendation(List<Coach> coaches) {
        Recommendation recommend = menuService.recommend(coaches);
        return recommend;
    }
}
