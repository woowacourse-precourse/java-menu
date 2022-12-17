package menu.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import menu.domain.Coach;
import menu.domain.Menu;

public class CoachRepository {
  private static final List<Coach> coaches = new ArrayList<>();

  public static List<Coach> coaches() {
    return Collections.unmodifiableList(coaches);
  }

  public static void addAllCoaches(List<Coach> coaches) {
    coaches.forEach(CoachRepository::addCoach);
  }

  public static void addCoach(Coach coach) {
    coaches.add(coach);
  }
}
