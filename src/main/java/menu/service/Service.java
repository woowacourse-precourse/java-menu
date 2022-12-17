package menu.service;

import menu.domain.Coach;
import menu.domain.Coaches;
import menu.domain.Menu;
import menu.domain.MenuRepository;

import java.util.List;

public class Service {
    private final Coaches coaches = new Coaches();

    public void setMenus() {
        MenuRepository.initialize();
    }

    public void setCoach(List<String> coachNames, List<List<String>> hateMenus) {
        for (int i = 0; i < coachNames.size(); i++) {
            Coach newCoach = new Coach(coachNames.get(i));
            coaches.addCoach(newCoach);
            addHateMenu(newCoach, hateMenus.get(i));
        }
    }

    public void recommend() {
       coaches.takeRecommend();
    }

    private void addHateMenu(Coach coach, List<String> hateMenuNames) {
        for (String menuName : hateMenuNames) {
            Menu menu = MenuRepository.getMenuByName(menuName);
            coach.addHateMenu(menu);
        }
    }
}
