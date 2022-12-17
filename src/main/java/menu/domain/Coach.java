package menu.domain;

import java.util.HashMap;
import java.util.List;
import menu.repository.ServiceRepository;

public class Coach {

  private String name;  //코치의 이름
  private List<String> excludedMenu;  //코치가 먹지 못하는 메뉴 리스트
  private HashMap<Day, String> menuList = new HashMap<>();  //코치의 요일별 추천 메뉴(서비스 결과)

  public Coach(String name) {
    this.name = name;
  }

  public void setExcludedMenu(List<String> excludedMenu) {
    this.excludedMenu = excludedMenu;
  }

  public void addMenuList(Day key, String menu) {
    this.menuList.put(key, menu);
  }

  public List<String> getExcludedMenu() {
    return excludedMenu;
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
