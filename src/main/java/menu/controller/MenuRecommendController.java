package menu.controller;

import menu.domain.Coach;
import menu.service.RecommendService;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MenuRecommendController {
    private final RecommendService recommendService;

    public MenuRecommendController() {
        recommendService = new RecommendService();
    }

    public void run() {
        List<String> coachesName = InputView.readCoachName();
        List<Coach> coaches = readAllCoachUableMenus(coachesName);
        recommendService.saveCoachs(coaches);
        List<String> category = recommendService.makeCategory();
        OutputView.printResult();
        OutputView.printCategory(category);
        Map<Coach, List<String>> recommendation = recommendService.makeMenuForAllCoach();
        OutputView.printRecommendation(recommendation);
    }
    public List<Coach> readAllCoachUableMenus(List<String> coachesName){
        List<Coach> coaches = new ArrayList<>();
        for(String coachName : coachesName){
            List<String> unableMenus = InputView.readUnableMenu(coachName);
            Coach coach = new Coach(coachName, unableMenus);
            coaches.add(coach);
        }
        return coaches;
    }

}
