package menu.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Coach {
  private String name;
  private Set<String> hateFood;

  public Coach(String name, Set<String> hateFood) {
    this.name = name;
    this.hateFood = hateFood;
  }

  public String getName() {
    return name;
  }

  public void insertHateFood(String hateFoodName) {
    hateFood.add(hateFoodName);
  }

  public List<String> getHateFood() {
    List<String> hateFoods = new ArrayList<>(hateFood);
    return hateFoods;
  }
}
