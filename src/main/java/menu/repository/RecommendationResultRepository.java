package menu.repository;

import static menu.repository.CoachRepository.coaches;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import menu.domain.Coach;
import menu.domain.Menu;

public class RecommendationResultRepository {

  private static final Map<Coach, List<Menu>> result = new HashMap<>();

  static {
    coaches().forEach(coach -> result.put(coach, Collections.emptyList()));
  }

  public static Map<Coach, List<Menu>> result() {
    return Collections.unmodifiableMap(result);
  }

  public static void addMenu(Coach coach, Menu menu) {
    result.get(coach).add(menu);
  }
  public static boolean existMenu(Coach coach, Menu menu) {
    return result.get(coach).contains(menu);
  }
}
