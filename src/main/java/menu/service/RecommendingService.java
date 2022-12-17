package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.*;
import menu.vo.Day;

public class RecommendingService {

    public static void doRecommending() {
        for (Day day : Day.values()) {
            Category category = Category.findByCommand(Randoms.pickNumberInRange(1, 5));
            recommendMenusToCoaches(day, category);
        }
    }

    private static void recommendMenusToCoaches(Day day, Category category) {
        for (Coach coach : CoachRepository.findAll()) {
            recommendMenusToCoach(day, category, coach);
        }
    }

    private static void recommendMenusToCoach(Day day, Category category, Coach coach) {
        Menu menu = MenuRepository.findRandomOneByCategoryAndCoach(category, coach);
        RecommendingRepository.save(day, new Recommending(coach, category, menu));
    }
}
