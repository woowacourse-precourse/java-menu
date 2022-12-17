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

public class MenuRecommendController {

    private static final List<Weekend> weekend= WeekendRepository.weekends();
    private static final List<Menu> menus = MenuRepository.menus();

    private final InputView inputView;

    public MenuRecommendController(){
        this.inputView = new InputView();
    }
    public void run() {
        List<Coach> coaches = getChoachs();
// TODO:
//        Map<Weekend,Menu> recommend = getRecommendMenus(weekend,menus,coaches);
//        OutPutView.printResult(recommended);
    }
// TODO:
//    private Map<Weekend, Menu> getRecommendMenus(List<Weekend> weekend, List<Menu> menus, List<Coach> coaches) {
//        return MenuRecommendService.recommend(coaches,weekend,menus);
//    }

    private List<Coach> getChoachs() {
        //TODO: 코치이름길이 검증, 코치인원수 검증
        //
        List<String> names = inputView.readCoachNames();
        List<Coach> coaches = new ArrayList<>();
        for (String name : names) {
            coaches.add(new Coach(name,inputView.getCanNotEatMenus(name)));
        }
        return coaches;
    }
}
