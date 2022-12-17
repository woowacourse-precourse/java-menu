package menu.domain.repository;

import menu.domain.Coach;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CoachRepository {
        private static final List<Coach> coachList = new ArrayList<>();

        // read-only
        public static List<Coach> coaches() {
            return Collections.unmodifiableList(coachList);
        }

        // add
        public static void addCoach(Coach coach) {
            coachList.add(coach);
        }

        // find
        public static Coach findCoachByName(String name) {
            return coachList.stream()
                    .filter(coach -> coach.getName().equals(name))
                    .findFirst()
                    .get();
        }

        public static void saveRandomFoodsToCoach(String coachName, String randomFood){
            findCoachByName(coachName).setRandomFood(randomFood);
        }

}


