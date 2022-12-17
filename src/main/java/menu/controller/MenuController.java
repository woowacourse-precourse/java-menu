package menu.controller;

import menu.model.CategoryResult;
import menu.model.Coach;
import menu.model.MenuResult;
import menu.model.RecommendResult;
import menu.service.MenuService;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MenuController {

    private InputView inputView;
    private OutputView outputView;
    private List<Coach> coachList;
    private MenuService menuService;
    private RecommendResult recommendResult;

    public MenuController() {
        inputView = new InputView();
        outputView = new OutputView();
        coachList = new ArrayList<>();
        menuService = new MenuService();
    }

    public void run() {
        start();
        readCoachInfo();
        recommendMenu();
        printResult();
        end();
    }

    public void recommendMenu() {
        recommendResult = menuService.recommendMenu(coachList);
    }

    public void start() {
        outputView.printStart();
    }

    public List<String> readCoachNames() {
        List<String> coachNames = null;
        do {
            outputView.printReadCoachNames();
            try {
                coachNames = inputView.readCoachNames();
                break;
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        } while (true);
        return coachNames;
    }

    public void readImpossibleMenus(String coachName) {
        outputView.printReadImpossibleMenus(coachName);
        List<String> impossibleMenuList = inputView.readImpossibleMenus();
        coachList.add(new Coach(coachName, impossibleMenuList));
    }

    public void readCoachInfo() {
        List<String> coachNames = readCoachNames();
        for (String coachName : coachNames) {
            readImpossibleMenus(coachName);
        }
    }

    public void printResult() {
        outputView.printResultHead();
        List<String> test = Arrays.asList("한식", "한식", "일식", "중식", "아시안");
        outputView.printCategoryResult(new CategoryResult(test));
        List<MenuResult> test2 = new ArrayList<>();
        test2.add(new MenuResult("토미", Arrays.asList("쌈밥", "김치찌개", "미소시루", "팟타이", "짜장면")));
        test2.add(new MenuResult("제임스", Arrays.asList("된장찌개", "비빔밥", "가츠동", "토마토 달걀볶음", "파인애플 볶음밥")));
        test2.add(new MenuResult("포코", Arrays.asList("된장찌개", "불고기", "하이라이스", "탕수육", "나시고렝")));

        recommendResult = new RecommendResult(new CategoryResult(test), test2);
        List<MenuResult> menuResults = recommendResult.getMenuResults();
        for (MenuResult menuResult : menuResults) {
            outputView.printMenuResult(menuResult);
        }
        outputView.printBlackLine();
    }

    public void end() {
        outputView.printEnd();
    }

}
