package menu.validation;


public class CoachNameValidation extends ValidationDecorator{

  public CoachNameValidation(Validation validation) {
    super(validation);
  }

  @Override
  public void validate(String input) {
    super.validate(input);
    String[] names = input.split(",");
    int size = names.length;
    if (size < 2 || size > 5) throw new IllegalArgumentException("[ERROR] 코치는 2명에서 5명 사이어야 합니다.");
    for (int i = 0; i < size; i++) {
      if(names[i].length() < 2 || names[i].length() > 4) throw new IllegalArgumentException("[ERROR] 코치의 이름은 2~4글자 사이어야 합니다.");
    }
  }
}
