package menu.service;

import menu.model.Coach;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class CoachService {

  private List<Coach> coaches = new ArrayList<>();

  public void makeCoaches(String coachName) {
    String[] coachesName = coachName.split(",");
    for (int i = 0; i < coachesName.length; i++) {
      coaches.add(new Coach(coachesName[i], new HashSet<>()));
    }
  }

  public void insertHateFood(String coachName, String hateFoodNames) {
    String[] hateFoods = hateFoodNames.split(",");
    Coach coach = coaches.stream().filter(it -> it.getName().equals(coachName)).findFirst().orElseThrow(IllegalArgumentException::new);
    for (int i = 0; i < hateFoods.length; i++) {
      coach.insertHateFood(hateFoods[i]);
    }
  }

}
