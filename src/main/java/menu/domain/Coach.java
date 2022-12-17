package menu.domain;

public class Coach {
  private String name;
  private String[] excludedMenu;

  public Coach(String name){
    this.name=name;
  }

  public void setExcludedMenu(String[] excludedMenu) {
    this.excludedMenu = excludedMenu;
  }

  public String getName(){
    return name;
  }
  public String toString(){
    String result="[ "+name+" | 쌈밥 | 김치찌개 | 미소시루 | 짜장면 | 팟타이 ]";
    return result;
  }
}
