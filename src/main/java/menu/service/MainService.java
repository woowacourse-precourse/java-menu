package menu.service;

import menu.domain.Coach;
import menu.domain.Coaches;
import menu.domain.Menu;
import java.util.List;
import java.util.stream.Collectors;

public class MainService {
    private Coaches coaches;

    public void generateCoaches(List<String> coachNames) {
        List<Coach> coaches = coachNames.stream()
                .map(Coach::new)
                .collect(Collectors.toList());
        this.coaches = new Coaches(coaches);
    }

    public void setCantEatMenus(List<String> hateMenus, String coachName) {
        for (String hateMenu : hateMenus) {
            if (!Menu.isExist(hateMenu)) {
                throw new IllegalArgumentException("존재하지 않는 메뉴를 입력했습니다. 다시 입력해 주세요.");
            }
        }

        Coach coach = coaches.findByName(coachName);
        coach.setHateMenus(hateMenus);
    }
}