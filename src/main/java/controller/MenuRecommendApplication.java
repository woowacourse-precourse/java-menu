package controller;

import menu.domain.Category;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class MenuRecommendApplication {
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private List<String> allMenu = new ArrayList<>();

    public MenuRecommendApplication() {
        List<List<String>> allMenuPerCategory = Category.getAllMenu();
        for (List<String> menus : allMenuPerCategory) {
            allMenu.addAll(menus);
        }
        //System.out.println(allMenu);
    }

    public void start() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
        List<String> coachNames = inputView.scanCoachNames();
        //System.out.println(coachNames);
        List<List<String>> hatesFood = scanHatesFood(coachNames);

//        토미(이)가 못 먹는 메뉴를 입력해 주세요.
    }

    private List<List<String>> scanHatesFood(List<String> coachNames) {
        List<List<String>> hatesFood = new ArrayList<>();
        for (String name : coachNames) {
            List<String> eachHatesFood = inputView.scanHatesFood(name);
            //있는 음식인지 확인 해야한다.
            checkValidFood(eachHatesFood);
            hatesFood.add(eachHatesFood);
        }
        return hatesFood;
    }

    private void checkValidFood(List<String> hatesFood) {
        for (String s : hatesFood) {
            if (!allMenu.contains(s)) {
                throw new IllegalArgumentException("[ERROR] 없는 메뉴 입니다.");
            }
        }
    }
}
