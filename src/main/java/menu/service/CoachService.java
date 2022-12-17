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

}
