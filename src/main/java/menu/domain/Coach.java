package menu.domain;

import java.util.HashMap;
import java.util.List;

public class Coach {
  private String name;
  private String[] excludedMenu;
  private HashMap<Day,List<String>> menuList=new HashMap<>();

  public Coach(String name){
    this.name=name;
  }

  public void setExcludedMenu(String[] excludedMenu) {
    this.excludedMenu = excludedMenu;
  }

  public void addMenuList(Day key,List<String> menuList) {
    this.menuList.put(key,menuList);
  }

  public String getName(){
    return name;
  }
  public String toString(){
    String result="[ "+name+" | 쌈밥 | 김치찌개 | 미소시루 | 짜장면 | 팟타이 ]";
    return result;
  }
}
