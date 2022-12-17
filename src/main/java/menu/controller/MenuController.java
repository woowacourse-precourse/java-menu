package menu.controller;

import java.util.List;
import java.util.stream.Collectors;
import menu.domain.Couch;
import menu.dto.CouchHateMenusRequest;
import menu.dto.CouchNamesRequest;
import menu.dto.RecommendCouchMenu;
import menu.service.MenuService;
import menu.view.MenuView;

public class MenuController {
    private final MenuService menuService;
    private final MenuView menuView;

    public MenuController(MenuService menuService, MenuView menuView) {
        this.menuService = menuService;
        this.menuView = menuView;
    }

    public void start() {
        menuView.printStartMessage();
        CouchNamesRequest couchNamesRequest = menuView.receiveCouches();
        menuService.saveCouches(couchNamesRequest);
        List<Couch> couches = menuService.getAllCouches();
        for (Couch couch : couches) {
            CouchHateMenusRequest couchHateMenusRequest = menuView.receiveCouchHateMenus(couch.getName());
            menuService.addHateMenusForCouch(couch, couchHateMenusRequest);
        }
        List<String> recommendCategories = menuService.createRecommendCategories();
        menuView.printResultCategories(recommendCategories);
        menuService.createRecommendCouchMenu(recommendCategories);
        List<RecommendCouchMenu> recommends = couches.stream()
                .map(RecommendCouchMenu::of)
                .collect(Collectors.toList());
        menuView.printResultMessage(recommends);
    }
}
