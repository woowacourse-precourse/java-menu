package menu.domain;

import static menu.view.ErrorMessage.COACH_NAME_SIZE_ERROR;

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
      throw new IllegalArgumentException(COACH_NAME_SIZE_ERROR.getMessage());
    }
  }
}
