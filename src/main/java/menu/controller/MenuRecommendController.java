package menu.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import menu.domain.Coach;
import menu.domain.Menu;
import menu.domain.MenuRecommendService;
import menu.domain.Weekend;
import menu.repository.MenuRepository;
import menu.repository.WeekendRepository;
import menu.view.InputView;
import menu.view.OutPutView;

public class MenuRecommendController {

    private static final List<Weekend> weekend = WeekendRepository.weekends();
    private static final List<Menu> menus = MenuRepository.menus();

    public void run() {
        List<Coach> coaches = getChoachs();
        Map<String, List<Menu>> recommend = getRecommendMenus(coaches);
        OutPutView.printResult(recommend);
    }

    private Map<String, List<Menu>> getRecommendMenus(List<Coach> coaches) {
        return MenuRecommendService.MakeNewRecommendMenu(coaches);
    }

    private List<Coach> getChoachs() {
        try{
            List<String> names;
            names = InputView.readCoachNames();
            return getChoachsCanNotEatMenu(names);
        }  catch (IllegalArgumentException exception){
            OutPutView.printError(exception);
            return getChoachs();
        }

    }

    private List<Coach> getChoachsCanNotEatMenu(List<String> names) {
        try {
            List<Coach> coaches = new ArrayList<>();
            for (String name : names) {
                coaches.add(new Coach(name, InputView.getCanNotEatMenus(name)));
            }
            return coaches;
        } catch (IllegalArgumentException exception){
            OutPutView.printError(exception);
            return getChoachsCanNotEatMenu(names);
        }
    }
}
