package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.Coach;
import menu.repository.MenuRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static menu.enums.Categories.*;

public class RecommendMenuServiceImpl implements RecommendMenuService {

    private final MenuRepository repository;
    public RecommendMenuServiceImpl() {
        repository = new MenuRepository();
    }

    public void recommend(List<Coach> coaches, List<String> categories) {
        categories.forEach(it -> selectMenuForCoach(coaches, it));
    }

    private void selectMenuForCoach(List<Coach> coaches, String category) {
        for (Coach coach : coaches) {
            String menu = getRandomMenu(category);
            addMenuToCoach(coach, menu);
        }
    }

    private void addMenuToCoach(Coach coach, String menu) {
        while (true) {
            if (coach.isNotRefuseMenu(menu) && coach.isFirstRecommendMenu(menu)) {
                coach.addRecommendMenu(menu);
                break;
            }
        }
    }

    private String getRandomMenu(String category) {
        return Randoms.shuffle(repository.getByCategory(category)).get(0);
    }
}
