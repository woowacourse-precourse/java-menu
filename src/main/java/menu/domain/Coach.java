package menu.domain;

import static menu.view.ErrorMessage.COACH_NAME_SIZE_ERROR;

import java.util.Arrays;

public class Coach {

  private static final int MIN_NAME = 2;
  private static final int MAX_NAME = 4;

  private String name;

  public Coach(String name) {
    validate(name);
    this.name = name;
  }

  public String getName() {
    return name;
  }

  private void validate(String name) {
    if (name.length() < MIN_NAME || name.length() > MAX_NAME) {
      throw new IllegalArgumentException(COACH_NAME_SIZE_ERROR.getMessage());
    }
  }
}
