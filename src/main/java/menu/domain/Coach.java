package menu.domain;

import java.util.HashMap;
import java.util.List;
import menu.repository.ServiceRepository;

public class Coach {

  private String name;
  private String[] excludedMenu;
  private HashMap<Day, String> menuList = new HashMap<>();

  public Coach(String name) {
    this.name = name;
  }

  public void setExcludedMenu(String[] excludedMenu) {
    this.excludedMenu = excludedMenu;
  }

  public void addMenuList(Day key, String menu) {
    this.menuList.put(key, menu);
  }

  public HashMap<Day, String> getMenuList() {
    return menuList;
  }

  public String getName() {
    return name;
  }

  public String toString() {
    String result = "[ " + name;
    for (Day day : Day.values()) {
      result += " | " + menuList.get(day);
    }
    result += " ]";
    return result;
  }
}
