package menu.domain;

import java.util.Arrays;

public class Coach {

  private String name;

  public Coach(String name) {
    validate(name);
    this.name = name;
  }

  public String getName() {
    return name;
  }

  private void validate(String name) {
    if (name.length() < 2 || name.length() > 4) {
      throw new IllegalArgumentException("코치의 이름은 최소 2글자, 최대 4글자 이어야 합니다.");
    }
  }
}
