package menu.validation;

public class InputValidation {

  public void validateCoachesName(String names) {
    Validation validation = new CoachNameValidation(new NullValidation());
    validation.validate(names);
  }

  public String validateHateFood(String foods) {
    if (foods.trim().length() == 0) return foods;
    String[] hateFoods = foods.split(",");
    int size = hateFoods.length;
    if (size < 0 || size > 2) throw new IllegalArgumentException("[ERROR] 못먹는 메뉴는 0~2개 사이어야 합니다.");
    return foods;
  }
}
