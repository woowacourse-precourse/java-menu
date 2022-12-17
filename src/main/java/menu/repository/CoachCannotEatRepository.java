package menu.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import menu.domain.Coach;

public class CoachCannotEatRepository {
  private static final Map<Coach, List<String>> coachesCannotEat = new HashMap<>();

  public static Map<Coach, List<String>> coachesCannotEat() {
    return Collections.unmodifiableMap(coachesCannotEat);
  }

  public static void addCoachCannotEat(Coach coach, List<String> menus) {
    coachesCannotEat.put(coach, menus);
  }
}
