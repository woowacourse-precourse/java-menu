package menu.validation;

public class NullValidation implements Validation{

  @Override
  public void validate(String input) {
    if (input == null || input.trim().length() == 0) {
      throw new IllegalArgumentException("[ERROR] 코치의 이름을 입력해주세요.");
    }
  }
}
