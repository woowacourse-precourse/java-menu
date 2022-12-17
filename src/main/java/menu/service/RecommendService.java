package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Day;
import menu.repository.CoachRepository;
import menu.repository.WeeklyMenuRepository;

import java.util.Arrays;
import java.util.List;

public class RecommendService {
    private WeeklyMenuRepository weeklyMenuRepository = new WeeklyMenuRepository();
    private CoachRepository coachRepository = new CoachRepository();
    public void createWeeklyRecommendMenu() {
        Arrays.stream(Day.values())
                .forEach(day -> recommendMenu(day));
    }

    private void recommendMenu(Day day) {
        Category category = getValidCategory();
        List<Coach> coaches = coachRepository.getCoaches();

    }

    private Category getValidCategory() {
        while (true) {
            Category randomCategory = Category.getRandomCategory();
            if (weeklyMenuRepository.isValidCategory(randomCategory)) {
                return randomCategory;
            }
        }
    }

    private String getRandomMenu(List<String> menus) {
        return Randoms.shuffle(menus).get(0);
    }
}
