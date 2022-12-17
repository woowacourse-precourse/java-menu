package menu.domain;

import menu.system.exception.MenuAlreadyRecommendedException;
import menu.vo.Day;

import java.util.*;

public class RecommendingRepository {
    private static final Map<Day, List<Recommending>> recommendings = new HashMap<>();

    static {
        for (Day day : Day.values()) {
            recommendings.put(day, new ArrayList<>());
        }
    }

    public static void save(Day day, Recommending recommending) {
        Validator.validateOnSaving(day, recommending);
        recommendings.get(day).add(recommending);
    }

    public static List<Menu> findAllMenusByCoach(Coach coach) {
        List<Menu> menus = new ArrayList<>();
        for (Day day : Day.values()) {
            if (!recommendings.get(day).isEmpty()) {
                Optional<Recommending> recommendingOptional = recommendings.get(day)
                        .stream().filter(recommending -> recommending.isCoach(coach))
                        .findFirst();
                recommendingOptional.ifPresent(recommending -> menus.add(recommending.getMenu()));
            }
        }
        return menus;
    }

    private static class Validator {
        public static void validateOnSaving(Day day, Recommending recommending) {
            if (isMenuAlreadyRecommended(recommending)) {
                throw new MenuAlreadyRecommendedException();
            }
        }

        private static boolean isMenuAlreadyRecommended(Recommending recommending) {
            return findAllMenusByCoach(recommending.getCoach()).contains(recommending.getMenu());
        }
    }
}
