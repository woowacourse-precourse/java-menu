package menu.dto;

import java.util.ArrayList;
import java.util.List;
import menu.domain.Coach;
import menu.domain.MenuRecommend;
import menu.domain.Weekday;
import menu.repository.CategoryRecommendRepository;
import menu.repository.CoachRepository;
import menu.repository.MenuRecommendRepository;

public class RecommendDTO {

    public static String getCategoryNames(Weekday weekday) {
        return CategoryRecommendRepository.findByWeekday(weekday).getCategory().getName();
    }

    public static List<String> getRecommendMenusOnCoach(Coach coach) {
        List<String> menus = new ArrayList<>();
        for (MenuRecommend menuRecommend : MenuRecommendRepository.findByCoach(coach)) {
            menus.add(menuRecommend.getFood().getName());
        }
        return menus;
    }

    public static List<Coach> getCoaches() {
        return CoachRepository.getCoaches();
    }
}
