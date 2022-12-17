package menu.controller;

import menu.domain.Couch;
import menu.domain.CouchService;
import menu.ui.InputView;

import java.util.Arrays;
import java.util.List;

public class MenuController {
    private InputView inputView = new InputView();
    private final String START = "점심 메뉴 추천을 시작합니다.";
    private CouchService couchService = new CouchService();

    public void doRecommendMenu() {
        System.out.println(START);
        registerCouches();
        registerCannotEat();
    }

    private void registerCouches() {
        while (true) {
            try {
                couchService.registerCouches(inputView.inputCouchNames());
                break;
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    private void registerCannotEat() {
        List<Couch> couches = couchService.getCouches();
        for (int i = 0; i < couches.size(); i++) {
            try {
                couches.get(i).setCannotEatFoods(Arrays.asList(inputView.inputCannotEat(couches.get(i).getName()).split(",")));
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
                i--;
            }
        }
    }

}
